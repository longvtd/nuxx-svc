package com.lguplus.nuxx.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lguplus.nuxx.common.UtilConstants;
import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.dto.InvoiceReqDTO;
import com.lguplus.nuxx.entity.InvoiceEntity;
import com.lguplus.nuxx.repository.InvoiceRepository;
import com.lguplus.wafful.event.WaffulEventPublisher;
import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;

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

	/**
	 * @name: 청구서서비스생성
	 * <PRE>청구서 저장소, Wafful REST 클라이언트 및 이벤트 발행자를 주입합니다.</PRE>
	 * @MethodName: InvoiceService
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceService(InvoiceRepository invoiceRepository, WaffulRestTemplate restTemplate,
	        WaffulEventPublisher eventPublisher) {
		this.invoiceRepository = invoiceRepository;
		this.restTemplate = restTemplate;
		this.eventPublisher = eventPublisher;
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
		restTemplate.post("{@nuxy-svc.api-createInvoice-001}", savedInvoice, savedInvoice.getInvoiceId());
		return savedInvoice;
	}
}