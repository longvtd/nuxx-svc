package com.lguplus.nuxx.dto;

/**
 * @name: Phone order request DTO
 * <PRE>
 * 휴대폰 주문 조회/저장 요청 데이터.
 * 주문 식별자를 전달합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneReqDTO.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneReqDTO {
	private String id;

	/**
	 * @name: 주문요청DTO기본생성
	 * <PRE>
	 * 빈 요청 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneReqDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneReqDTO() {
	}

	/**
	 * @name: 주문요청DTO생성
	 * <PRE>
	 * 주문 식별자로 요청 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneReqDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneReqDTO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
