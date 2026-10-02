package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;
import com.util.ExpApiUriInterface;

/**
 * V7a - constant from implemented interface, no qualifier.
 */
public class V7aInterfaceConstantUserService implements ExpApiUriInterface {

    private final WaffulRestTemplete restTemplate;

    public V7aInterfaceConstantUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveIface(String id) {
        return restTemplate.get(URL_API_USER_IFACE, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveIfaceThis(String id) {
        return this.restTemplate.get(URL_API_USER_IFACE, new Obj(), id);
    }
}
