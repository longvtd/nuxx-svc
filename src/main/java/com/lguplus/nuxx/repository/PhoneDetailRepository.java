package com.lguplus.nuxx.repository;

import java.util.List;

import com.lguplus.nuxx.entity.PhoneDetailEntity;

/**
 * @name: Phone detail repository
 * <PRE>
 * 휴대폰 주문 상세 저장소.
 * 주문 식별자로 상세 목록을 조회합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDetailRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public class PhoneDetailRepository {
	/**
	 * @name: 주문상세조회
	 * <PRE>
	 * [DB-READ-01] repository read
	 * 휴대폰 식별자로 주문 상세를 조회합니다.
	 * </PRE>
	 * @MethodName: findByPhoneId
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public List<PhoneDetailEntity> findByPhoneId(String id) {
		return List.of(new PhoneDetailEntity("D-1", id));
	}
}
