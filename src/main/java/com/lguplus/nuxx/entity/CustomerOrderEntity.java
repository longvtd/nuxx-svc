package com.lguplus.nuxx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 홈주문고객주문마스터
 * <PRE>
 * 고객 주문 마스터 테이블의 주문, 고객, 휴대폰 식별자와 상태를 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : CustomerOrderEntity.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Entity
@Table(name = "TB_HM_CUST_ORDER_M")
public class CustomerOrderEntity extends Audit {
    @Id
    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "PHONE_ID")
    private String phoneId;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    /**
     * @name: 고객주문엔티티기본생성
     * <PRE>JPA가 고객 주문 엔티티를 생성할 때 사용하는 기본 생성자입니다.</PRE>
     * @MethodName: CustomerOrderEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public CustomerOrderEntity() {
    }

    /**
     * @name: 고객주문엔티티생성
     * <PRE>주문, 고객, 휴대폰 식별자와 상태로 엔티티를 생성합니다.</PRE>
     * @MethodName: CustomerOrderEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public CustomerOrderEntity(String orderId, String custId, String phoneId, String orderStatus) {
        this.orderId = orderId;
        this.custId = custId;
        this.phoneId = phoneId;
        this.orderStatus = orderStatus;
    }

    /**
     * @name: 주문식별자조회
     * <PRE>고객 주문 식별자를 반환합니다.</PRE>
     * @MethodName: getOrderId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @name: 주문식별자설정
     * <PRE>고객 주문 식별자를 설정합니다.</PRE>
     * @MethodName: setOrderId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @name: 고객식별자조회
     * <PRE>주문 고객 식별자를 반환합니다.</PRE>
     * @MethodName: getCustId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @name: 고객식별자설정
     * <PRE>주문 고객 식별자를 설정합니다.</PRE>
     * @MethodName: setCustId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @name: 휴대폰식별자조회
     * <PRE>주문에 연결된 휴대폰 식별자를 반환합니다.</PRE>
     * @MethodName: getPhoneId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getPhoneId() {
        return phoneId;
    }

    /**
     * @name: 휴대폰식별자설정
     * <PRE>주문에 연결된 휴대폰 식별자를 설정합니다.</PRE>
     * @MethodName: setPhoneId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * @name: 주문상태조회
     * <PRE>고객 주문 상태를 반환합니다.</PRE>
     * @MethodName: getOrderStatus
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @name: 주문상태설정
     * <PRE>고객 주문 상태를 설정합니다.</PRE>
     * @MethodName: setOrderStatus
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
