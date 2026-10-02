package com.lguplus.nuxx.dto;

/**
 * @name: Phone order detail DTO
 * <PRE>
 * 휴대폰 주문 상세 전송 데이터.
 * 상세 식별자, 주문 식별자, 고객명을 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDetailDTO.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneDetailDTO {
	private String id;
	private String phoneId;
	private String custNm;

	/**
	 * @name: 주문상세DTO생성
	 * <PRE>
	 * 상세 식별자와 주문 식별자로 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneDetailDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneDetailDTO(String id, String phoneId) {
		this.id = id;
		this.phoneId = phoneId;
	}

	public String getId() {
		return id;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public String getCustNm() {
		return custNm;
	}

	/**
	 * @name: 고객명설정
	 * <PRE>
	 * 주문 상세에 고객명을 설정합니다.
	 * </PRE>
	 * @MethodName: setCustNm
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void setCustNm(String name) {
		custNm = name;
	}
}
