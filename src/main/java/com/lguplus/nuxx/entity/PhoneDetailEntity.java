package com.lguplus.nuxx.entity;

import com.lguplus.wafful.jpa.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_hm_phone_d")
public class PhoneDetailEntity extends Audit {

    @Id
    @Column(name = "phone_dtl_id")
    private String id; //휴대폰 주문 상세 ID

    @Column(name = "phone_id")
    private String phoneId; //휴대폰 주문 ID

    public String getId() {
        return id;
    }

    public String getPhoneId() {
        return phoneId;
    }
}
