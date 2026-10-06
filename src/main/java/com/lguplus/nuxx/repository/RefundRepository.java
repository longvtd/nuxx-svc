package com.lguplus.nuxx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lguplus.nuxx.entity.RefundEntity;

/**
 * @name: 환불저장소
 * <PRE>환불 엔티티를 Spring Data JPA 방식으로 저장합니다.</PRE>
 * @class: RefundRepository.java
 * @Date: 2026. 10. 06.
 */
@Repository
public interface RefundRepository extends JpaRepository<RefundEntity, String> {
}
