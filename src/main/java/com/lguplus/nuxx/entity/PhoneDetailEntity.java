package com.lguplus.nuxx.entity;

/**
 * @name: Phone order detail entity
 * <PRE>
 * 휴대폰 주문 상세 도메인 데이터.
 * 상세 식별자와 주문 식별자를 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDetailEntity.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneDetailEntity {
	private final String id;
	private final String phoneId;

	/**
	 * @name: 주문상세엔티티생성
	 * <PRE>
	 * 상세 식별자와 주문 식별자로 엔티티를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneDetailEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneDetailEntity(String id, String phoneId) {
		this.id = id;
		this.phoneId = phoneId;
	}

	public String getId() {
		return id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}
