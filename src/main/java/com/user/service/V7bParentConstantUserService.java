package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import com.util.BaseApiClient;
import java.util.List;

/**
 * V7b - constant AND restTemplate field inherited from superclass BaseApiClient.
 */
public class V7bParentConstantUserService extends BaseApiClient {

    public V7bParentConstantUserService(WaffulRestTemplete restTemplate) {
        super(restTemplate);
    }

    public List<UserInfoDTO> retrieveParent(String id) {
        return restTemplate.get(URL_API_USER_PARENT, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveParentThis(String id) {
        return this.restTemplate.get(URL_API_USER_PARENT, new Obj(), id);
    }
}
