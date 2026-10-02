package com.lguplus.nuxx.dto;

/**
 * @name: SMS DTO
 * <PRE>
 * SMS 발송 메시지 데이터.
 * 대상 식별자와 건수를 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : SmsDTO.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class SmsDTO {
	private final String id;
	private final int count;

	/**
	 * @name: SMS DTO생성
	 * <PRE>
	 * 대상 식별자와 발송 건수로 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: SmsDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public SmsDTO(String id, int count) {
		this.id = id;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public int getCount() {
		return count;
	}
}
