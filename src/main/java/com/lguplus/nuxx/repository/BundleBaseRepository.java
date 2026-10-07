package com.lguplus.nuxx.repository;
import com.lguplus.nuxx.entity.BundleBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BundleBaseRepository extends JpaRepository<BundleBaseEntity, String> { }
