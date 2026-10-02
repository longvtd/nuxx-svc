package com.lguplus.nuxx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @name: 홈주문휴대폰마스터
 * <PRE>
 * 홈주문 휴대폰 마스터 테이블의 식별자, 이름 및 사용 여부를 표현합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PhoneEntity.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Entity
@Table(name = "TB_HM_PHONE_M")
public class PhoneEntity extends Audit {
    @Id
    @Column(name = "PHONE_ID")
    private String id;

    @Column(name = "PHONE_NM")
    private String name;

    @Column(name = "USE_YN")
    private String useYn;

    /**
     * @name: 휴대폰엔티티기본생성
     * <PRE>JPA가 엔티티를 생성할 때 사용하는 기본 생성자입니다.</PRE>
     * @MethodName: PhoneEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public PhoneEntity() {
    }

    /**
     * @name: 휴대폰엔티티생성
     * <PRE>기존 서비스 흐름에서 사용하는 주문 식별자와 사용 여부로 생성합니다.</PRE>
     * @MethodName: PhoneEntity
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public PhoneEntity(String id, String useYn) {
        this.id = id;
        this.useYn = useYn;
    }

    /**
     * @name: 휴대폰식별자조회
     * <PRE>휴대폰 주문 식별자를 반환합니다.</PRE>
     * @MethodName: getId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getId() {
        return id;
    }

    /**
     * @name: 휴대폰식별자설정
     * <PRE>휴대폰 주문 식별자를 설정합니다.</PRE>
     * @MethodName: setId
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @name: 휴대폰사용여부조회
     * <PRE>휴대폰 주문의 사용 여부 코드를 반환합니다.</PRE>
     * @MethodName: getUseYn
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * @name: 휴대폰사용여부설정
     * <PRE>휴대폰 주문의 사용 여부 코드를 설정합니다.</PRE>
     * @MethodName: setUseYn
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * @name: 휴대폰주문명조회
     * <PRE>휴대폰 주문 이름을 반환합니다.</PRE>
     * @MethodName: getName
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getName() {
        return name;
    }

    /**
     * @name: 휴대폰주문명설정
     * <PRE>휴대폰 주문 이름을 설정합니다.</PRE>
     * @MethodName: setName
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setName(String name) {
        this.name = name;
    }
}
