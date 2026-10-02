package com.lguplus.nuxx.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.lguplus.wafful.jpa.JpaResultMapper;
import org.springframework.stereotype.Repository;

/**
 * @name: 홈주문휴대폰네이티브저장소
 * <PRE>
 * EntityManager native SQL을 사용하여 휴대폰 이름과 주문 요약을 조회하고 사용 여부를 변경합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderNativeQueryRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Repository
public class HmOrderNativeQueryRepository {
    private final JpaResultMapper jpaResultMapper = new JpaResultMapper();
    private final EntityManager em;

    /**
     * @name: 네이티브저장소생성
     * <PRE>JPA native SQL 실행을 위한 EntityManager를 주입합니다.</PRE>
     * @MethodName: HmOrderNativeQueryRepository
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public HmOrderNativeQueryRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * @name: 휴대폰명조회
     * <PRE>[DB-READ-02] EntityManager native SELECT / TB_HM_PHONE_M</PRE>
     * @MethodName: selectPhoneName
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String selectPhoneName(String id) {
        Object name = em.createNativeQuery(
                        "SELECT PHONE_NM FROM TB_HM_PHONE_M WHERE PHONE_ID = :id")
                .setParameter("id", id)
                .getSingleResult();
        return jpaResultMapper.toText(name);
    }

    /**
     * @name: 휴대폰주문요약조회
     * <PRE>[DB-JOIN-01] native SELECT JOIN / TB_HM_PHONE_M, TB_HM_PHONE_D, TB_HM_CUST_ORDER_M</PRE>
     * @MethodName: selectPhoneOrderSummary
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public List<?> selectPhoneOrderSummary(String phoneId) {
        return em.createNativeQuery(
                        "SELECT P.PHONE_ID, P.PHONE_NM, D.DETAIL_ID, D.ITEM_NM, O.ORDER_ID, O.ORDER_STATUS FROM TB_HM_PHONE_M P JOIN TB_HM_PHONE_D D ON D.PHONE_ID = P.PHONE_ID JOIN TB_HM_CUST_ORDER_M O ON O.PHONE_ID = P.PHONE_ID WHERE P.PHONE_ID = :phoneId")
                .setParameter("phoneId", phoneId)
                .getResultList();
    }

    /**
     * @name: 휴대폰사용여부변경
     * <PRE>[DB-WRITE-02] EntityManager native UPDATE / TB_HM_PHONE_M</PRE>
     * @MethodName: updatePhoneUseYn
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public int updatePhoneUseYn(String phoneId, String useYn) {
        return em.createNativeQuery(
                        "UPDATE TB_HM_PHONE_M SET USE_YN = :useYn, "
                                + "CHG_DTTM = CURRENT_TIMESTAMP WHERE PHONE_ID = :phoneId")
                .setParameter("useYn", useYn)
                .setParameter("phoneId", phoneId)
                .executeUpdate();
    }
}
