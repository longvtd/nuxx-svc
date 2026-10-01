package com.lguplus.nuxx.dto;

import com.lguplus.nuxx.entity.PhoneEntity;
import com.lguplus.wafful.vo.BaseVO;
import java.util.ArrayList;
import java.util.List;

public class PhoneDTO extends BaseVO {

    private String id;
    private String useYn;

    public PhoneDTO(String id, String useYn) {
        this.id = id;
        this.useYn = useYn;
    }

    public String getId() {
        return id;
    }

    public PhoneEntity toEntity() {
        PhoneEntity entity = new PhoneEntity();
        entity.setId(id);
        entity.setUseYn(useYn);
        return entity;
    }

    public static List<PhoneDTO> fromEntities(List<PhoneEntity> entities) {
        List<PhoneDTO> result = new ArrayList<>();
        for (PhoneEntity entity : entities) {
            result.add(new PhoneDTO(entity.getId(), entity.getUseYn()));
        }
        return result;
    }
}
