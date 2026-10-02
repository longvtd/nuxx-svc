package com.lguplus.nuxx.dto;

/**
 * @name: Customer DTO
 * <PRE>
 * 고객 연계 전송 데이터.
 * 고객 식별자와 고객명을 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : CustDTO.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class CustDTO {
	private String custId;
	private String custNm;

	/**
	 * @name: 고객DTO기본생성
	 * <PRE>
	 * 빈 고객 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: CustDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public CustDTO() {
	}

	/**
	 * @name: 고객DTO생성
	 * <PRE>
	 * 고객 식별자와 고객명으로 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: CustDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public CustDTO(String id, String name) {
		custId = id;
		custNm = name;
	}

	public String getCustId() {
		return custId;
	}

	public String getCustNm() {
		return custNm;
	}

	/**
	 * @name: 고객명설정
	 * <PRE>
	 * 고객명을 설정합니다.
	 * </PRE>
	 * @MethodName: setCustNm
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public void setCustNm(String v) {
		custNm = v;
	}
}
