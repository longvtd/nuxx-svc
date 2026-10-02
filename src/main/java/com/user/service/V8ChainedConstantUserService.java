package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;
import com.util.ExpApiUriConstant;

/**
 * V8 - chained constant across 3 classes (A = B, B = C, C = literal).
 */
public class V8ChainedConstantUserService {

    private final WaffulRestTemplete restTemplate;

    public V8ChainedConstantUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveChain(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_USER_CHAIN, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveChainThis(String id) {
        return this.restTemplate.get(ExpApiUriConstant.URL_API_USER_CHAIN, new Obj(), id);
    }
}
