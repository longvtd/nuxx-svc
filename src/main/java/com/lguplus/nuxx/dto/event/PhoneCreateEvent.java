package com.lguplus.nuxx.dto.event;

/**
 * @name: Phone create event
 * <PRE>
 * 휴대폰 주문 생성 이벤트 페이로드.
 * 생성된 주문 식별자를 전달합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneCreateEvent.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneCreateEvent {
	private final String phoneId;

	/**
	 * @name: 주문생성이벤트생성
	 * <PRE>
	 * 휴대폰 주문 식별자로 생성 이벤트를 구성합니다.
	 * </PRE>
	 * @MethodName: PhoneCreateEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneCreateEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}
