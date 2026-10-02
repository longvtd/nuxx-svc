package com.lguplus.nuxx.dto.event;

/**
 * @name: Phone delete event
 * <PRE>
 * 휴대폰 주문 삭제 이벤트 페이로드.
 * 삭제 대상 주문 식별자를 전달합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDeleteEvent.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneDeleteEvent {
	private final String phoneId;

	/**
	 * @name: 주문삭제이벤트생성
	 * <PRE>
	 * 휴대폰 주문 식별자로 삭제 이벤트를 구성합니다.
	 * </PRE>
	 * @MethodName: PhoneDeleteEvent
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneDeleteEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}
