package com.lguplus.nuxx.entity;

/**
 * @name: Phone order entity
 * <PRE>
 * 휴대폰 주문 도메인 데이터.
 * 주문 식별자, 사용여부, 주문 이름을 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneEntity.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneEntity {
	private String id;
	private String useYn;
	private String name;

	/**
	 * @name: 휴대폰주문엔티티생성
	 * <PRE>
	 * 주문 식별자와 사용여부로 엔티티를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneEntity(String id, String useYn) {
		this.id = id;
		this.useYn = useYn;
	}

	public String getId() {
		return id;
	}

	public String getUseYn() {
		return useYn;
	}

	/**
	 * @name: 주문명설정
	 * <PRE>
	 * 휴대폰 주문 이름을 설정합니다.
	 * </PRE>
	 * @MethodName: setName
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void setName(String v) {
		name = v;
	}

	public String getName() {
		return name;
	}
}
