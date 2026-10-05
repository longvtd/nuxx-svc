package com.lguplus.nuxx.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.nuxx.dto.PaymentReqDTO;
import com.lguplus.nuxx.entity.PaymentEntity;
import com.lguplus.nuxx.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: 결제컨트롤러
 * <PRE>
 * 결제 생성 REST 요청을 결제 서비스로 전달합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PaymentController.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@RestController
@Tag(name = "payment API", description = "결제 API")
@RequestMapping("/payment")
public class PaymentController {
	private final PaymentService paymentService;

	/**
	 * @name: 결제컨트롤러생성
	 * <PRE>결제 서비스 의존성을 주입합니다.</PRE>
	 * @MethodName: PaymentController
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	/**
	 * @name: 결제생성요청
	 * <PRE>고객 식별자와 금액으로 결제를 생성하고 저장합니다.</PRE>
	 * @MethodName: createPayment
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	@Operation(summary = "결제생성", description = "고객 결제를 생성합니다.")
	@PostMapping("/create-payment")
	public PaymentEntity createPayment(@ParameterObject PaymentReqDTO request) {
		return paymentService.createPayment(request);
	}
}
