package com.lguplus.nuxx.dto.event;

/**
 * @name: Phone update event
 * <PRE>
 * 휴대폰 주문 변경 이벤트 페이로드.
 * 변경 대상 주문 식별자를 전달합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneUpdateEvent.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneUpdateEvent {
	private final String phoneId;

	/**
	 * @name: 주문변경이벤트생성
	 * <PRE>
	 * 휴대폰 주문 식별자로 변경 이벤트를 구성합니다.
	 * </PRE>
	 * @MethodName: PhoneUpdateEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneUpdateEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}
