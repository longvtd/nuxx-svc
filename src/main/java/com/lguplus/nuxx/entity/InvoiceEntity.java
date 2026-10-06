package com.lguplus.nuxx.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 고객청구서
 * <PRE>
 * 고객에게 발행하는 청구서의 식별자, 금액, 상태 및 생성 시각을 보유합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : InvoiceEntity.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Entity
@Table(name = "TB_HM_INVOICE_M")
public class InvoiceEntity {
	@Id
	@Column(name = "INVOICE_ID")
	private String invoiceId;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_TIME")
	private LocalDateTime createdTime;

	/**
	 * @name: 청구서엔티티기본생성
	 * <PRE>JPA가 청구서 엔티티를 생성할 때 사용하는 기본 생성자입니다.</PRE>
	 * @MethodName: InvoiceEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceEntity() {
	}

	/**
	 * @name: 청구서엔티티생성
	 * <PRE>청구서의 식별자, 고객, 금액, 상태 및 생성 시각을 설정합니다.</PRE>
	 * @MethodName: InvoiceEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public InvoiceEntity(String invoiceId, String customerId, BigDecimal amount, String status,
	        LocalDateTime createdTime) {
		this.invoiceId = invoiceId;
		this.customerId = customerId;
		this.amount = amount;
		this.status = status;
		this.createdTime = createdTime;
	}

	/**
	 * @name: 청구서식별자조회
	 * <PRE>청구서 식별자를 반환합니다.</PRE>
	 * @MethodName: getInvoiceId
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @name: 고객식별자조회
	 * <PRE>청구 대상 고객 식별자를 반환합니다.</PRE>
	 * @MethodName: getCustomerId
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @name: 청구금액조회
	 * <PRE>청구 금액을 반환합니다.</PRE>
	 * @MethodName: getAmount
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @name: 청구상태조회
	 * <PRE>청구서 상태를 반환합니다.</PRE>
	 * @MethodName: getStatus
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @name: 청구서생성시각조회
	 * <PRE>청구서 생성 시각을 반환합니다.</PRE>
	 * @MethodName: getCreatedTime
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 05. 21:00:00
	 */
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
}