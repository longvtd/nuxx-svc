package com.lguplus.nuxx.repository;

import java.util.List;

import com.lguplus.nuxx.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @name: 홈주문고객주문저장소
 * <PRE>
 * 고객 주문 마스터 엔티티의 표준 JPA 저장 및 고객 식별자 조회 기능을 제공합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : CustomerOrderRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, String> {
    /**
     * @name: 고객별주문조회
     * <PRE>[DB-READ-04] derived repository query / TB_HM_CUST_ORDER_M</PRE>
     * @MethodName: findByCustId
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    List<CustomerOrderEntity> findByCustId(String custId);
}
