package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;

/**
 * V1 - URL is a string literal (regression baseline).
 */
public class V1LiteralUserService {

    private final WaffulRestTemplete restTemplate;

    public V1LiteralUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveLiteral(String id) {
        return restTemplate.get("{@do-01.api-selectUserLiteral-001}", new Obj(), id);
    }

    public List<UserInfoDTO> retrieveLiteralThis(String id) {
        return this.restTemplate.get("{@do-01.api-selectUserLiteral-001}", new Obj(), id);
    }
}
