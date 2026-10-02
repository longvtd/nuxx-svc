package com.user.service;

import static com.util.ExpApiUriConstant.URL_API_USERINFO;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;
import com.util.ExpApiUriConstant;

/**
 * D1 - SAME API do-01.api-selectUser-001 called with 5 styles. Expect ONE ExternalApi node.
 */
public class D1DedupeUserService {

    private final WaffulRestTemplete restTemplate;

    public D1DedupeUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> dedupeLiteral(String id) {
        return restTemplate.get("{@nuxy-svc.api-selectUser-001}", new Obj(), id);
    }

    public List<UserInfoDTO> dedupeQualified(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }

    public List<UserInfoDTO> dedupeStaticImport(String id) {
        return this.restTemplate.get(URL_API_USERINFO, new Obj(), id);
    }

    public List<UserInfoDTO> dedupeFqn(String id) {
        return this.restTemplate.get(com.util.ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }

    /** C1 - placeholder uses uppercase DO-01. */
    public List<UserInfoDTO> dedupeUppercaseDomain(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO_UPPER, new Obj(), id);
    }
}
