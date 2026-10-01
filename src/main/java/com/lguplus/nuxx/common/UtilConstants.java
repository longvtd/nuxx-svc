package com.lguplus.nuxx.common;

/**
 * @name: 공통 상수
 * <PRE>
 * Kafka 토픽 및 컨슈머 그룹 상수
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : UtilConstants.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
public final class UtilConstants {

    /*
     * Kafka 컨슈머 그룹
     */
    public static final String GROUP_TOPIC_ORDER = "cg_from_nuxx_order_event"; //홈주문 신규 주문 수집 그룹

    /*
     * Kafka 토픽
     */
    public static final String TOPIC_PHONE_TB = "from_hm_phone_tb_event"; //휴대폰 주문 생성 이벤트 (2자리 코드: 패턴 불일치)
    public static final String TOPIC_SMS = "to_hm_sms_message"; //SMS 발송 메시지
    public static final String TOPIC_CUST = "to_nuxy_cust_event"; //고객 도메인 주문 알림 (패턴 매핑: NUXY-SVC)
    public static final String TOPIC_POINT = "to_zzzz_point_event"; //포인트 알림 (카탈로그 미등록 코드)

    private UtilConstants() {
    }
}
