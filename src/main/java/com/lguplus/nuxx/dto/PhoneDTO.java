package com.lguplus.nuxx.dto;

import java.util.ArrayList;
import java.util.List;

import com.lguplus.nuxx.entity.PhoneEntity;

/**
 * @name: Phone order DTO
 * <PRE>
 * 휴대폰 주문 전송 데이터.
 * 주문 식별자와 사용여부를 표현하고 엔티티와 상호 변환합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDTO.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneDTO {
	private final String id;
	private final String useYn;

	/**
	 * @name: 휴대폰주문DTO생성
	 * <PRE>
	 * 주문 식별자와 사용여부로 DTO를 생성합니다.
	 * </PRE>
	 * @MethodName: PhoneDTO
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneDTO(String id, String useYn) {
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
	 * @name: 엔티티변환
	 * <PRE>
	 * 휴대폰 주문 DTO를 엔티티로 변환합니다.
	 * </PRE>
	 * @MethodName: toEntity
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public PhoneEntity toEntity() {
		return new PhoneEntity(id, useYn);
	}

	/**
	 * @name: 엔티티목록변환
	 * <PRE>
	 * 휴대폰 주문 엔티티 목록을 DTO 목록으로 변환합니다.
	 * </PRE>
	 * @MethodName: fromEntities
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public static List<PhoneDTO> fromEntities(List<PhoneEntity> es) {
		List<PhoneDTO> r = new ArrayList<>();
		for (PhoneEntity e : es)
			r.add(new PhoneDTO(e.getId(), e.getUseYn()));
		return r;
	}
}
