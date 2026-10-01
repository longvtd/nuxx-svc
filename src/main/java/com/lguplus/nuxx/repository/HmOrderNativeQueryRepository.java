package com.lguplus.nuxx.repository;

import com.lguplus.wafful.jpa.JpaResultMapper;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class HmOrderNativeQueryRepository {

    private final JpaResultMapper jpaResultMapper = new JpaResultMapper();
    private final EntityManager em;

    public HmOrderNativeQueryRepository(EntityManager em) {
        this.em = em;
    }

    public String selectPhoneName(String id) {
        Object name = em.createNativeQuery("SELECT NAME FROM TB_HM_PHONE_M WHERE ID = :id")
                .setParameter("id", id)
                .getSingleResult();
        return jpaResultMapper.toText(name);
    }
}
