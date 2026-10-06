package com.lguplus.nuxx.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 환불
 * <PRE>환불 식별자, 원결제, 고객, 금액, 상태와 생성 시각을 보유합니다.</PRE>
 * @class: RefundEntity.java
 * @Date: 2026. 10. 06.
 */
@Entity
@Table(name = "TB_HM_REFUND_M")
public class RefundEntity {
    @Id
    @Column(name = "REFUND_ID")
    private String refundId;

    @Column(name = "PAYMENT_ID")
    private String paymentId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "REFUND_AMOUNT")
    private BigDecimal refundAmount;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    public RefundEntity() {
    }

    public RefundEntity(String refundId, String paymentId, String customerId,
            BigDecimal refundAmount, String status, LocalDateTime createdTime) {
        this.refundId = refundId;
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.refundAmount = refundAmount;
        this.status = status;
        this.createdTime = createdTime;
    }

    public String getRefundId() {
        return refundId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
