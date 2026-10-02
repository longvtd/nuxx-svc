package com.lguplus.nuxx.repository;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import com.lguplus.nuxx.entity.PhoneEntity;
import org.springframework.stereotype.Repository;

/**
 * @name: 홈주문휴대폰사용자정의저장소구현
 * <PRE>
 * EntityManager를 사용하여 휴대폰 고객별 조회와 주문명 변경 SQL을 실행합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderRepositoryImpl.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Repository
public class HmOrderRepositoryImpl implements HmOrderRepositoryCustom {
    private final EntityManager entityManager;

    /**
     * @name: 사용자정의저장소생성
     * <PRE>네이티브 SQL 실행을 위한 EntityManager를 주입합니다.</PRE>
     * @MethodName: HmOrderRepositoryImpl
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public HmOrderRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @name: 고객별사용중휴대폰조회
     * <PRE>[DB-READ-02] EntityManager native SELECT / TB_HM_PHONE_M</PRE>
     * @MethodName: findActivePhonesByCustomer
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<PhoneEntity> findActivePhonesByCustomer(String custId) {
        Query query = entityManager.createNativeQuery(
                "SELECT P.PHONE_ID, P.PHONE_NM, P.USE_YN FROM TB_HM_PHONE_M P "
                        + "WHERE P.CUST_ID = :custId AND P.USE_YN = 'Y'");
        List<Object[]> rows = (List<Object[]>) query.setParameter("custId", custId).getResultList();
        List<PhoneEntity> phones = new ArrayList<>();
        for (Object[] row : rows) {
            PhoneEntity phone = new PhoneEntity();
            phone.setId(row[0] == null ? null : row[0].toString());
            phone.setName(row[1] == null ? null : row[1].toString());
            phone.setUseYn(row[2] == null ? null : row[2].toString());
            phones.add(phone);
        }
        return phones;
    }

    /**
     * @name: 휴대폰주문명변경
     * <PRE>[DB-WRITE-02] EntityManager native UPDATE / TB_HM_PHONE_M</PRE>
     * @MethodName: updatePhoneName
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    @Override
    public int updatePhoneName(String phoneId, String phoneName) {
        return entityManager.createNativeQuery(
                        "UPDATE TB_HM_PHONE_M SET PHONE_NM = :phoneName, "
                                + "CHG_DTTM = CURRENT_TIMESTAMP WHERE PHONE_ID = :phoneId")
                .setParameter("phoneName", phoneName)
                .setParameter("phoneId", phoneId)
                .executeUpdate();
    }
}
