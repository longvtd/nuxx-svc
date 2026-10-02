package com.lguplus.nuxx.repository;

/**
 * @name: Home order native query repository
 * <PRE>
 * 휴대폰 주문 이름 조회 저장소.
 * 식별자에 대응하는 주문 이름을 반환합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderNativeQueryRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class HmOrderNativeQueryRepository {
	/**
	 * @name: 휴대전화주문명조회
	 * <PRE>
	 * [DB-READ-01] repository read
	 * 주문 식별자에 대응하는 휴대폰 이름을 조회합니다.
	 * </PRE>
	 * @MethodName: selectPhoneName
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public String selectPhoneName(String id) {
		return "phone-" + id;
	}
}
