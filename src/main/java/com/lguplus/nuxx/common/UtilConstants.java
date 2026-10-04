package com.lguplus.nuxx.common;

/**
 * @name: Utility constants
 * <PRE>
 * Kafka 토픽 및 구독 그룹 상수 목록.
 * 주문, SMS, 고객 알림, 포인트 연계 역할에 사용합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : UtilConstants.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public final class UtilConstants {
	/**
	 * @name: 상수클래스생성차단
	 * <PRE>
	 * 인스턴스 생성을 방지합니다.
	 * </PRE>
	 * @MethodName: UtilConstants
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	private UtilConstants() {
	}

	public static final String TOPIC_PHONE_TB = "to_nuxx_phone_event"; //import data phone to home phone
	public static final String TOPIC_SMS = "to_nuxa_sms_event";  //sent sms to home contact
	public static final String TOPIC_CUST = "to_nuxy_cust_event"; //...
	public static final String TOPIC_POINT = "to_zzzz_point_event";
	public static final String GROUP_TOPIC_ORDER = "nuxx_order_group";
}
