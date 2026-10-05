package com.lguplus.nuxx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lguplus.nuxx.entity.PaymentEntity;

/**
 * @name: 결제저장소
 * <PRE>결제 엔티티를 표준 Spring Data JPA 방식으로 저장합니다.</PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : PaymentRepository.java
 * @Date   : 2026. 10. 05.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 05.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {
}
