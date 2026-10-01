package com.lguplus.nuxx.repository;

import com.lguplus.nuxx.entity.PhoneEntity;
import com.lguplus.wafful.jpa.WaffulQuerydslSupport;

public class HmOrderRepositoryImpl extends WaffulQuerydslSupport implements HmOrderRepositoryCustom {

    public HmOrderRepositoryImpl() {
        super(PhoneEntity.class);
    }

    @Override
    public String selectPhoneNameByQuerydsl(String id) {
        return String.valueOf(select("name", id));
    }
}
