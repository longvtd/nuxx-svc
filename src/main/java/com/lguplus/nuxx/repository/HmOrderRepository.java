package com.lguplus.nuxx.repository;

import com.lguplus.nuxx.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @name: 홈주문휴대폰저장소
 * <PRE>
 * 홈주문 휴대폰 마스터 엔티티의 표준 JPA 및 사용자 정의 저장소 기능을 제공합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmOrderRepository.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Repository
public interface HmOrderRepository
        extends JpaRepository<PhoneEntity, String>, HmOrderRepositoryCustom {
}
