package com.lguplus.nuxx.entity;

import com.lguplus.wafful.jpa.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_hm_phone_m")
public class PhoneEntity extends Audit {

    @Id
    @Column(name = "phone_id")
    private String id; //휴대폰 주문 ID

    @Column(name = "phone_nm")
    private String name; //휴대폰명

    @Column(name = "use_yn")
    private String useYn; //사용여부

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }
}
