package com.lguplus.nuxx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 홈주문휴대폰상세
 * <PRE>
 * 홈주문 휴대폰 상세 테이블의 상세 식별자, 주문 식별자 및 항목명을 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneDetailEntity.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Entity
@Table(name = "TB_HM_PHONE_D")
public class PhoneDetailEntity extends Audit {
    @Id
    @Column(name = "DETAIL_ID")
    private String id;

    @Column(name = "PHONE_ID")
    private String phoneId;

    @Column(name = "ITEM_NM")
    private String itemName;

    /**
     * @name: 휴대폰상세엔티티기본생성
     * <PRE>JPA가 상세 엔티티를 생성할 때 사용하는 기본 생성자입니다.</PRE>
     * @MethodName: PhoneDetailEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public PhoneDetailEntity() {
    }

    /**
     * @name: 휴대폰상세엔티티생성
     * <PRE>기존 상세 조회 흐름에서 사용하는 식별자로 엔티티를 생성합니다.</PRE>
     * @MethodName: PhoneDetailEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public PhoneDetailEntity(String id, String phoneId) {
        this.id = id;
        this.phoneId = phoneId;
    }

    /**
     * @name: 상세식별자조회
     * <PRE>주문 상세 식별자를 반환합니다.</PRE>
     * @MethodName: getId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getId() {
        return id;
    }

    /**
     * @name: 상세식별자설정
     * <PRE>주문 상세 식별자를 설정합니다.</PRE>
     * @MethodName: setId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @name: 휴대폰식별자조회
     * <PRE>주문 상세가 참조하는 휴대폰 식별자를 반환합니다.</PRE>
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
     * <PRE>주문 상세가 참조하는 휴대폰 식별자를 설정합니다.</PRE>
     * @MethodName: setPhoneId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * @name: 상세항목명조회
     * <PRE>주문 상세 항목명을 반환합니다.</PRE>
     * @MethodName: getItemName
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @name: 상세항목명설정
     * <PRE>주문 상세 항목명을 설정합니다.</PRE>
     * @MethodName: setItemName
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
