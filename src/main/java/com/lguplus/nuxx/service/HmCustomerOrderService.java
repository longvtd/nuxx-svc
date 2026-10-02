package com.lguplus.nuxx.service;

import java.util.List;

import com.lguplus.nuxx.entity.CustomerOrderEntity;
import com.lguplus.nuxx.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

/**
 * @name: 홈주문고객주문서비스
 * <PRE>
 * 고객 주문 마스터의 고객별 조회와 고객 주문 저장을 담당합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmCustomerOrderService.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Service
public class HmCustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    /**
     * @name: 고객주문서비스생성
     * <PRE>고객 주문 JPA 저장소를 주입합니다.</PRE>
     * @MethodName: HmCustomerOrderService
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public HmCustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    /**
     * @name: 고객별주문조회
     * <PRE>[DB-READ-04] derived repository query / TB_HM_CUST_ORDER_M</PRE>
     * @MethodName: retrieveCustomerOrders
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public List<CustomerOrderEntity> retrieveCustomerOrders(String custId) {
        return customerOrderRepository.findByCustId(custId);
    }

    /**
     * @name: 고객주문저장
     * <PRE>[DB-WRITE-04] JpaRepository save / TB_HM_CUST_ORDER_M</PRE>
     * @MethodName: saveCustomerOrder
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public CustomerOrderEntity saveCustomerOrder(CustomerOrderEntity order) {
        return customerOrderRepository.save(order);
    }
}
