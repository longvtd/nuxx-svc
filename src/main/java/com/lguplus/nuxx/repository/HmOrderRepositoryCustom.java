package com.lguplus.nuxx.repository;

import java.util.List;

import com.lguplus.nuxx.entity.PhoneEntity;

/**
 * @name: 홈주문휴대폰사용자정의저장소
 * <PRE>
 * 휴대폰 고객 조건 조회와 휴대폰 이름 변경을 위한 사용자 정의 저장소 계약입니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderRepositoryCustom.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public interface HmOrderRepositoryCustom {
    /**
     * @name: 고객별사용중휴대폰조회
     * <PRE>[DB-READ-02] EntityManager native SELECT / TB_HM_PHONE_M</PRE>
     * @MethodName: findActivePhonesByCustomer
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    List<PhoneEntity> findActivePhonesByCustomer(String custId);

    /**
     * @name: 휴대폰주문명변경
     * <PRE>[DB-WRITE-02] EntityManager native UPDATE / TB_HM_PHONE_M</PRE>
     * @MethodName: updatePhoneName
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    int updatePhoneName(String phoneId, String phoneName);
}
