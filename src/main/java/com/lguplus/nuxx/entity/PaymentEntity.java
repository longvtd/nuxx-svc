package com.lguplus.nuxx.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 결제
 * <PRE>
 * 결제 식별자, 고객, 결제 금액, 상태 및 생성 시각을 보유합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PaymentEntity.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Entity
@Table(name = "TB_HM_PAYMENT_M")
public class PaymentEntity {
	@Id
	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_TIME")
	private LocalDateTime createdTime;

	/**
	 * @name: 결제엔티티기본생성
	 * <PRE>JPA가 결제 엔티티를 생성할 때 사용하는 기본 생성자입니다.</PRE>
	 * @MethodName: PaymentEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentEntity() {
	}

	/**
	 * @name: 결제엔티티생성
	 * <PRE>결제의 식별자, 고객, 금액, 상태 및 생성 시각을 설정합니다.</PRE>
	 * @MethodName: PaymentEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public PaymentEntity(String paymentId, String customerId, BigDecimal amount, String status,
	        LocalDateTime createdTime) {
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.amount = amount;
		this.status = status;
		this.createdTime = createdTime;
	}

	/**
	 * @name: 결제식별자조회
	 * <PRE>결제 식별자를 반환합니다.</PRE>
	 * @MethodName: getPaymentId
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getPaymentId() {
		return paymentId;
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
	 * <PRE>결제 금액을 반환합니다.</PRE>
	 * @MethodName: getAmount
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @name: 결제상태조회
	 * <PRE>결제 상태를 반환합니다.</PRE>
	 * @MethodName: getStatus
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @name: 결제생성시각조회
	 * <PRE>결제 생성 시각을 반환합니다.</PRE>
	 * @MethodName: getCreatedTime
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
}
