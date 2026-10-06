package com.lguplus.nuxx.dto;

import java.math.BigDecimal;

/**
 * @name: 환불생성요청
 * <PRE>결제 식별자, 고객 식별자와 환불 금액을 전달합니다.</PRE>
 * @class: RefundReqDTO.java
 * @Date: 2026. 10. 06.
 */
public class RefundReqDTO {
    private String paymentId;
    private String customerId;
    private BigDecimal refundAmount;

    public RefundReqDTO() {
    }

    public RefundReqDTO(String paymentId, String customerId, BigDecimal refundAmount) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.refundAmount = refundAmount;
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
}
