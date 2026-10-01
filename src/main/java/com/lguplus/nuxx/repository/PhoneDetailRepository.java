package com.lguplus.nuxx.repository;

import com.lguplus.nuxx.entity.PhoneDetailEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneDetailRepository extends JpaRepository<PhoneDetailEntity, String> {

    List<PhoneDetailEntity> findByPhoneId(String phoneId);
}
