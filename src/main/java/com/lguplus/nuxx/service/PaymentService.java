package com.lguplus.nuxx.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.PaymentReqDTO;
import com.lguplus.nuxx.entity.PaymentEntity;
import com.lguplus.nuxx.repository.PaymentRepository;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;

/**
 * @name: 결제서비스
 * <PRE>
 * 결제 요청을 검증하고 저장한 뒤 결제 요청 이벤트와 외부 결제 API를 호출합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PaymentService.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Service
@Transactional
public class PaymentService {
	private final PaymentRepository paymentRepository;
	private final WaffulRestTemplate restTemplate;
	private final WaffulEventPublisher eventPublisher;

	/**
	 * @name: 결제서비스생성
	 * <PRE>결제 저장소, Wafful REST 클라이언트 및 이벤트 발행자를 주입합니다.</PRE>
	 * @MethodName: PaymentService
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentService(PaymentRepository paymentRepository, WaffulRestTemplate restTemplate,
	        WaffulEventPublisher eventPublisher) {
		this.paymentRepository = paymentRepository;
		this.restTemplate = restTemplate;
		this.eventPublisher = eventPublisher;
	}

	/**
	 * @name: 결제생성
	 * <PRE>
	 * 결제 요청을 검증하고 REQUESTED 결제를 저장한 뒤 결제 요청 이벤트와 외부 결제 API를 호출합니다.
	 * [DB-WRITE-01] JpaRepository save / TB_HM_PAYMENT_M
	 * [KAFKA-01] WaffulEventPublisher.publish / to_nuxx_payment_requested_event
	 * [OUT-01] WaffulRestTemplate.post / {@nuxy-svc.api-requestPayment-001}
	 * </PRE>
	 * @MethodName: createPayment
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentEntity createPayment(PaymentReqDTO request) {
		if (request == null) {
			throw new IllegalArgumentException("Payment request is required");
		}
		if (request.getCustomerId() == null || request.getCustomerId().isBlank()) {
			throw new IllegalArgumentException("Customer ID is required");
		}
		if (request.getAmount() == null || request.getAmount().signum() <= 0) {
			throw new IllegalArgumentException("Payment amount must be positive");
		}

		PaymentEntity payment = new PaymentEntity(UUID.randomUUID().toString(), request.getCustomerId(),
		        request.getAmount(), "REQUESTED", LocalDateTime.now());
		PaymentEntity savedPayment = paymentRepository.save(payment);
		eventPublisher.publish(UtilConstants.TOPIC_PAYMENT_REQUESTED, savedPayment.getPaymentId(), savedPayment);
		restTemplate.post("{@nuxy-svc.api-requestPayment-001}", savedPayment, savedPayment.getPaymentId());
		return savedPayment;
	}
}
