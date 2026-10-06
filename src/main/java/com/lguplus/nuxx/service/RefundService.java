package com.lguplus.nuxx.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lguplus.nuxx.common.RefundConstants;
import com.lguplus.nuxx.dto.RefundReqDTO;
import com.lguplus.nuxx.entity.RefundEntity;
import com.lguplus.nuxx.repository.RefundRepository;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;

/**
 * @name: 환불서비스
 * <PRE>환불 요청을 검증하고 저장한 뒤 Kafka 이벤트를 발행하고 외부 환불 API를 호출합니다.</PRE>
 * @class: RefundService.java
 * @Date: 2026. 10. 06.
 */
@Service
@Transactional
public class RefundService {
    private static final BigDecimal MANUAL_REVIEW_THRESHOLD = new BigDecimal("1000000");

    private final RefundRepository refundRepository;
    private final WaffulRestTemplate restTemplate;
    private final WaffulEventPublisher eventPublisher;

    public RefundService(RefundRepository refundRepository, WaffulRestTemplate restTemplate,
            WaffulEventPublisher eventPublisher) {
        this.refundRepository = refundRepository;
        this.restTemplate = restTemplate;
        this.eventPublisher = eventPublisher;
    }

    /**
     * @name: 환불생성
     * <PRE>
     * 환불 요청을 검증하고 고액 환불 여부에 따라 상태를 결정하여 저장합니다.
     * 저장 후 환불 요청 이벤트를 발행하고 외부 환불 API를 호출합니다.
     * [DB-WRITE-01] JpaRepository save / TB_HM_REFUND_M
     * [KAFKA-01] WaffulEventPublisher.publish / to_nuxx_refund_requested_event
     * [OUT-01] WaffulRestTemplate.post / {@nuxy-svc.api-requestRefund-001}
     * </PRE>
     * @MethodName: createRefund
     * @Part: 차세대 아키텍처
     */
    public RefundEntity createRefund(RefundReqDTO request) {
        validateRequest(request);

        String status = RefundConstants.STATUS_REQUESTED;
        if (request.getRefundAmount().compareTo(MANUAL_REVIEW_THRESHOLD) >= 0) {
            status = RefundConstants.STATUS_REVIEW_REQUIRED;
        }

        RefundEntity refund = new RefundEntity(
                UUID.randomUUID().toString(),
                request.getPaymentId(),
                request.getCustomerId(),
                request.getRefundAmount(),
                status,
                LocalDateTime.now());

        RefundEntity savedRefund = refundRepository.save(refund);
        eventPublisher.publish(RefundConstants.TOPIC_REFUND_REQUESTED,
                savedRefund.getRefundId(), savedRefund);
        restTemplate.post("{@nuxy-svc.api-requestRefund-001}",
                savedRefund, savedRefund.getRefundId());
        return savedRefund;
    }

    /**
     * @name: 환불요청검증
     * <PRE>필수 식별자와 양수의 환불 금액을 검증합니다.</PRE>
     * @MethodName: validateRequest
     * @Part: 차세대 아키텍처
     */
    private void validateRequest(RefundReqDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Refund request is required");
        }
        if (request.getPaymentId() == null || request.getPaymentId().isBlank()) {
            throw new IllegalArgumentException("Payment ID is required");
        }
        if (request.getCustomerId() == null || request.getCustomerId().isBlank()) {
            throw new IllegalArgumentException("Customer ID is required");
        }
        if (request.getRefundAmount() == null || request.getRefundAmount().signum() <= 0) {
            throw new IllegalArgumentException("Refund amount must be positive");
        }
    }
}
