package com.lguplus.nuxx.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.nuxx.dto.InvoiceReqDTO;
import com.lguplus.nuxx.entity.InvoiceEntity;
import com.lguplus.nuxx.service.InvoiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: 청구서컨트롤러
 * <PRE>청구서 생성 REST 요청을 서비스로 전달합니다.</PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : InvoiceController.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@RestController
@Tag(name = "invoice API", description = "고객 청구서 API")
@RequestMapping("/invoice")
public class InvoiceController {
	private final InvoiceService invoiceService;

	/**
	 * @name: 청구서컨트롤러생성
	 * <PRE>청구서 서비스 의존성을 주입합니다.</PRE>
	 * @MethodName: InvoiceController
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	/**
	 * @name: 청구서생성요청
	 * <PRE>고객 식별자와 금액으로 청구서를 생성하고 저장합니다.</PRE>
	 * @MethodName: createInvoice
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	@Operation(summary = "청구서생성", description = "고객 청구서를 생성합니다.")
	@PostMapping("/create-invoice")
	public InvoiceEntity createInvoice(@ParameterObject InvoiceReqDTO request) {
		return invoiceService.createInvoice(request);
	}
	
	/**
	 * @name: 청구서생성요청 iphone
	 * <PRE>iphone - 고객 식별자와 금액으로 청구서를 생성하고 저장합니다.</PRE>
	 * @MethodName: createInvoiceIphone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	@Operation(summary = "청구서생성-iphone", description = "iphone 고객 청구서를 생성합니다.")
	@PostMapping("/create-invoice-iphone")
	public InvoiceEntity createInvoiceIphone(@ParameterObject InvoiceReqDTO request) {
		return invoiceService.createInvoiceIphone(request);
	}
	
	/**
	 * @name: Update 청구서생성요청 iphone
	 * <PRE>Update iphone - 고객 식별자와 금액으로 청구서를 생성하고 저장합니다.</PRE>
	 * @MethodName: createInvoiceIphone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	@Operation(summary = "Update - 청구서생성-iphone", description = "Update iphone 고객 청구서를 생성합니다.")
	@PostMapping("/update-invoice-iphone")
	public InvoiceEntity updateInvoiceIphone(@ParameterObject InvoiceReqDTO request) {
		return invoiceService.updateInvoiceIphone(request);
	}
}