package com.lguplus.nuxx.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.dto.InvoiceReqDTO;
import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.RefundReqDTO;
import com.lguplus.nuxx.entity.InvoiceEntity;
import com.lguplus.nuxx.repository.InvoiceRepository;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;
import com.lguplus.wafful.framework.util.NullUtil;

/**
 * @name: 청구서서비스
 * <PRE>청구 요청을 검증하고 저장한 뒤 청구 이벤트와 고객 External API를 호출합니다.</PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : InvoiceService.java
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
public class InvoiceService {
	private final InvoiceRepository invoiceRepository;
	private final WaffulRestTemplate restTemplate;
	private final WaffulEventPublisher eventPublisher;
	private final RefundService refundService;
	private final HmOrderService hmOrderService;
	private final HmCustClientService custClient;

	/**
	 * @name: 청구서서비스생성
	 * <PRE>청구서 저장소, Wafful REST 클라이언트 및 이벤트 발행자를 주입합니다.</PRE>
	 * @MethodName: InvoiceService
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceService(InvoiceRepository invoiceRepository, WaffulRestTemplate restTemplate,
	        WaffulEventPublisher eventPublisher, RefundService refundService, HmOrderService hmOrderService, HmCustClientService custClient) {
		this.invoiceRepository = invoiceRepository;
		this.restTemplate = restTemplate;
		this.eventPublisher = eventPublisher;
		this.refundService = refundService;
		this.hmOrderService = hmOrderService;
		this.custClient = custClient;
	}

	/**
	 * @name: 청구서생성
	 * <PRE>
	 * 유효한 고객 청구 요청을 저장하고 청구 이벤트 및 외부 고객 청구 API를 호출합니다.
	 * [DB-WRITE-01] JpaRepository save / TB_HM_INVOICE_M
	 * [KAFKA-01] WaffulEventPublisher.publish / to_nuxx_invoice_event
	 * [OUT-01] WaffulRestTemplate.post / {@nuxy-svc.api-createInvoice-001}
	 * </PRE>
	 * @MethodName: createInvoice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceEntity createInvoice(InvoiceReqDTO request) {
		
		if (request == null || request.getCustomerId() == null || request.getCustomerId().isBlank()
		        || request.getAmount() == null || request.getAmount().signum() <= 0) {
			throw new IllegalArgumentException("Customer ID and a positive invoice amount are required");
		}
		String url = "{@nuxz-svc.selectCust-001}";
		CustDTO custDTO =  (CustDTO) restTemplate.post(url, new Object(), request.getCustomerId());
		InvoiceEntity invoice = new InvoiceEntity(UUID.randomUUID().toString(), custDTO.getCustId(),
		        request.getAmount(), "CREATED", LocalDateTime.now());
		InvoiceEntity savedInvoice = invoiceRepository.save(invoice);
		eventPublisher.publish(UtilConstants.TOPIC_INVOICE, savedInvoice.getInvoiceId(), savedInvoice);

		RefundReqDTO reqDto = (RefundReqDTO) restTemplate.post("{@nuxy-svc.api-createInvoice-001}", savedInvoice, savedInvoice.getInvoiceId());
		validateRefundRequest(reqDto);
		refundService.createRefund(reqDto);
		
		return savedInvoice;
	}
	
	/**
     * @name: 환불요청검증
     * <PRE>필수 식별자와 양수의 환불 금액을 검증합니다.</PRE>
     * @MethodName: validateRequest
     * @Part: 차세대 아키텍처
     */
    private void validateRefundRequest(RefundReqDTO request) {
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
    /**
	 * @name: 청구서생성 Iphone
	 * <PRE>
	 * Iphone - 유효한 고객 청구 요청을 저장하고 청구 이벤트 및 외부 고객 청구 API를 호출합니다.
	 * [DB-WRITE-01] JpaRepository save / TB_HM_INVOICE_M
	 * [KAFKA-01] WaffulEventPublisher.publish / to_nuxx_invoice_event
	 * [OUT-01] WaffulRestTemplate.post / {@nuxy-svc.api-createInvoice-001}
	 * </PRE>
	 * @MethodName: createInvoice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceEntity createInvoiceIphone(InvoiceReqDTO request) {
		if (NullUtil.isNull(request)) {
			throw new BizException("Customer ID and a positive invoice amount are required");
		}
		if (NullUtil.isNone(request.getCustomerId())) {
			request.setCustomerId(UUIDUtil.genAlphaNumericRandomUUID(32));
	    }
		InvoiceEntity invoice = new InvoiceEntity(UUID.randomUUID().toString(), request.getCustomerId(),
		        request.getAmount(), "CREATED", LocalDateTime.now());
		InvoiceEntity savedInvoice = invoiceRepository.save(invoice);
		
		CustDTO cust = custClient.selectCustProfile(savedInvoice.getCustomerId());
		PhoneDTO phoneDTO = new PhoneDTO(cust.getCustId(), cust.getCustNm());
		hmOrderService.createPhoneTbEvent(phoneDTO);
		return savedInvoice;
	}
	
	/**
	 * @name: Update 청구서생성 Iphone
	 * <PRE>
	 * Update Iphone - 유효한 고객 청구 요청을 저장하고 청구 이벤트 및 외부 고객 청구 API를 호출합니다.
	 * [DB-WRITE-01] JpaRepository save / TB_HM_INVOICE_M
	 * [KAFKA-01] WaffulEventPublisher.publish / to_nuxx_invoice_event
	 * [OUT-01] WaffulRestTemplate.post / {@nuxy-svc.api-createInvoice-001}
	 * </PRE>
	 * @MethodName: createInvoice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceEntity updateInvoiceIphone(InvoiceReqDTO request) {
		if (NullUtil.isNull(request)) {
			throw new BizException("Customer ID and a positive invoice amount are required.");
		}
		if (NullUtil.isNone(request.getCustomerId())) {
			request.setCustomerId(UUIDUtil.genAlphaNumericRandomUUID(32));
	    }
		String url = "{@nuxz-svc.selectCust-001}";
		CustDTO custDTO =  (CustDTO) restTemplate.post(url, new Object(), request.getCustomerId());
		if (NullUtil.isNull(custDTO)) {
			throw new BizException("Please enter CustomerId is exist!!!");
		}

		InvoiceEntity invoice = new InvoiceEntity(UUID.randomUUID().toString(), request.getCustomerId(),
		        request.getAmount(), "UPDATE", LocalDateTime.now());
		InvoiceEntity savedInvoice = invoiceRepository.save(invoice);
		
		CustDTO cust = custClient.selectCustProfile(savedInvoice.getCustomerId());
		PhoneDTO phoneDTO = new PhoneDTO(cust.getCustId(), cust.getCustNm());
		hmOrderService.createPhoneTbEvent(phoneDTO);
		return savedInvoice;
	}
}