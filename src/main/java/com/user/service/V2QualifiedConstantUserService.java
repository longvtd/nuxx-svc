package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;
import com.util.ExpApiUriConstant;

/**
 * V2 - qualified constant: ExpApiUriConstant.URL_API_USERINFO.
 */
public class V2QualifiedConstantUserService {

    private final WaffulRestTemplete restTemplate;

    public V2QualifiedConstantUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveListUserInfo(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveListUserInfoThis(String id) {
        return this.restTemplate.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }
}
