package com.lguplus.nuxx.repository;

import com.lguplus.nuxx.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HmOrderRepository extends JpaRepository<PhoneEntity, String>, HmOrderRepositoryCustom {
}
