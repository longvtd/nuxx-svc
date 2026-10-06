package com.lguplus.nuxx.common;

/**
 * @name: 환불상수
 * <PRE>환불 처리에 필요한 Kafka 토픽과 업무 기준값을 정의합니다.</PRE>
 * @class: RefundConstants.java
 * @Date: 2026. 10. 06.
 */
public final class RefundConstants {
    public static final String TOPIC_REFUND_REQUESTED = "to_nuxz_refund_requested_event";
    public static final String STATUS_REQUESTED = "REQUESTED";
    public static final String STATUS_REVIEW_REQUIRED = "REVIEW_REQUIRED";

    private RefundConstants() {
    }
}
