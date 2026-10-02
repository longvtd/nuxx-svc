package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import com.util.CycleConstantA;
import com.util.ExpApiUriConstant;
import java.util.List;

/**
 * NEGATIVE cases. No ExternalApi edge may be created; scan must not fail or hang.
 */
public class N1UnresolvedUserService {

    private final WaffulRestTemplete restTemplate;

    public N1UnresolvedUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    /** N1 - runtime concatenation. */
    public List<UserInfoDTO> unresolvedRuntimeConcat(String apiId, String id) {
        return restTemplate.get("{@do-01." + apiId + "}", new Obj(), id);
    }

    /** N2 - URL returned by a method call. */
    public List<UserInfoDTO> unresolvedMethodCall(String id) {
        return this.restTemplate.get(buildUrl(id), new Obj(), id);
    }

    /** N3 - cyclic constant A -> B -> A. */
    public List<UserInfoDTO> unresolvedCycle(String id) {
        return restTemplate.get(CycleConstantA.URL_CYCLE_A, new Obj(), id);
    }

    /** N4 - static but NOT final field. */
    public List<UserInfoDTO> unresolvedNotFinal(String id) {
        return this.restTemplate.get(ExpApiUriConstant.URL_API_NOT_FINAL, new Obj(), id);
    }

    /** N5 - local variable. */
    public List<UserInfoDTO> unresolvedLocalVariable(String id) {
        String url = id.isEmpty() ? "{@do-01.api-selectUserA-001}" : "{@do-01.api-selectUserB-001}";
        return restTemplate.get(url, new Obj(), id);
    }

    /** N6 - constant resolves, but api id is NOT in domain-api.yml. */
    public List<UserInfoDTO> notInCatalogApi(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_NOT_IN_CATALOG, new Obj(), id);
    }

    /** N7 - constant resolves, but domain id is NOT in domain.yml. */
    public List<UserInfoDTO> unknownDomain(String id) {
        return this.restTemplate.get(ExpApiUriConstant.URL_API_UNKNOWN_DOMAIN, new Obj(), id);
    }

    private String buildUrl(String id) {
        return "{@do-01.api-selectUserDynamic" + id + "}";
    }
}
