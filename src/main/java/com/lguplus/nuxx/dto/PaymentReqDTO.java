package com.lguplus.nuxx.dto;

import java.math.BigDecimal;

/**
 * @name: 결제생성요청
 * <PRE>
 * 고객 식별자와 결제 금액으로 결제 생성을 요청합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PaymentReqDTO.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PaymentReqDTO {
	private String customerId;
	private BigDecimal amount;

	/**
	 * @name: 결제요청기본생성
	 * <PRE>요청 바인딩에 사용하는 기본 생성자입니다.</PRE>
	 * @MethodName: PaymentReqDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentReqDTO() {
	}

	/**
	 * @name: 결제요청생성
	 * <PRE>고객 식별자와 결제 금액으로 요청 객체를 생성합니다.</PRE>
	 * @MethodName: PaymentReqDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentReqDTO(String customerId, BigDecimal amount) {
		this.customerId = customerId;
		this.amount = amount;
	}

	/**
	 * @name: 고객식별자조회
	 * <PRE>결제 대상 고객 식별자를 반환합니다.</PRE>
	 * @MethodName: getCustomerId
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @name: 결제금액조회
	 * <PRE>요청된 결제 금액을 반환합니다.</PRE>
	 * @MethodName: getAmount
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public BigDecimal getAmount() {
		return amount;
	}
}
