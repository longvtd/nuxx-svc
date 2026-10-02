package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;

/**
 * V6 - constant declared in the same class.
 */
public class V6LocalConstantUserService {

    private static final String URL_API_USER_LOCAL = "{@nuxy-svc.api-selectUserLocal-001}"; // api user local

    public static final String URL_API_USER_LOCAL_PUBLIC = "{@nuxy-svc.api-selectUserLocalPublic-001}"; // api user local public

    private final WaffulRestTemplete restTemplate;

    public V6LocalConstantUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveLocal(String id) {
        return restTemplate.get(URL_API_USER_LOCAL, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveLocalThis(String id) {
        return this.restTemplate.get(URL_API_USER_LOCAL, new Obj(), id);
    }

    /** Own class name qualifier. */
    public List<UserInfoDTO> retrieveLocalPublicQualified(String id) {
        return this.restTemplate.get(V6LocalConstantUserService.URL_API_USER_LOCAL_PUBLIC, new Obj(), id);
    }
}
