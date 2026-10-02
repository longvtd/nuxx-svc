package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;

/**
 * V3 - fully qualified constant, constant class NOT imported.
 */
public class V3FqnConstantUserService {

    private final WaffulRestTemplete restTemplate;

    public V3FqnConstantUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveFqn(String id) {
        return restTemplate.get(com.util.ExpApiUriConstant.URL_API_USERINFO_FQN, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveFqnThis(String id) {
        return this.restTemplate.get(com.util.ExpApiUriConstant.URL_API_USERINFO_FQN, new Obj(), id);
    }
}
