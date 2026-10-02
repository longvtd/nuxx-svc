package com.lguplus.nuxx.dto;

import com.lguplus.wafful.vo.BaseVO;

public class PhoneDetailDTO extends BaseVO {

    private final String id;
    private final String phoneId;
    private final String custNm;

    public PhoneDetailDTO(String id, String phoneId) {
        this.id = id;
        this.phoneId = phoneId;
    }

    public String getId() {
        return id;
    }

    public String getPhoneId() {
        return phoneId;
    }
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }
}
