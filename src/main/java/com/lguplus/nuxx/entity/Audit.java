package com.lguplus.nuxx.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @name: 공통감사정보
 * <PRE>
 * 휴대폰 주문 엔티티가 공유하는 등록 및 변경 감사 정보를 보유합니다.
 * 별도 테이블을 나타내지 않는 JPA 매핑 상위 클래스입니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : Audit.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@MappedSuperclass
public abstract class Audit {
    @Column(name = "REG_DTTM")
    private LocalDateTime registeredAt;

    @Column(name = "REG_USER_ID")
    private String registeredBy;

    @Column(name = "CHG_DTTM")
    private LocalDateTime changedAt;

    @Column(name = "CHG_USER_ID")
    private String changedBy;

    /**
     * @name: 등록일시조회
     * <PRE>엔티티의 등록 일시를 반환합니다.</PRE>
     * @MethodName: getRegisteredAt
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    /**
     * @name: 등록일시설정
     * <PRE>엔티티의 등록 일시를 설정합니다.</PRE>
     * @MethodName: setRegisteredAt
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    /**
     * @name: 등록자조회
     * <PRE>등록 사용자 식별자를 반환합니다.</PRE>
     * @MethodName: getRegisteredBy
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getRegisteredBy() {
        return registeredBy;
    }

    /**
     * @name: 등록자설정
     * <PRE>등록 사용자 식별자를 설정합니다.</PRE>
     * @MethodName: setRegisteredBy
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    /**
     * @name: 변경일시조회
     * <PRE>최근 변경 일시를 반환합니다.</PRE>
     * @MethodName: getChangedAt
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    /**
     * @name: 변경일시설정
     * <PRE>최근 변경 일시를 설정합니다.</PRE>
     * @MethodName: setChangedAt
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    /**
     * @name: 변경자조회
     * <PRE>최근 변경 사용자 식별자를 반환합니다.</PRE>
     * @MethodName: getChangedBy
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public String getChangedBy() {
        return changedBy;
    }

    /**
     * @name: 변경자설정
     * <PRE>최근 변경 사용자 식별자를 설정합니다.</PRE>
     * @MethodName: setChangedBy
     * @Part: 차세대 아키텍처
     * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
     * @ModifiedDate: 2026. 10. 02. 21:00:00
     */
    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }
}
