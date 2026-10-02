package com.user.service;

import static com.util.ExpApiUriConstant.*;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;
import com.util.ExpApiUriConstant;

/**
 * V5 - wildcard static import + normal class import (exact reported sample).
 */
public class V5StaticWildcardImportUserService {

    private final WaffulRestTemplete restTemplate;

    public V5StaticWildcardImportUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveWildcard(String id) {
        return restTemplate.get(URL_API_USER_WILDCARD, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveWildcardThis(String id) {
        return this.restTemplate.get(URL_API_USER_WILDCARD, new Obj(), id);
    }

    /** Reported sample: qualified constant. */
    public List<UserInfoDTO> retrieveListUserInfo(String id) {
        return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }

    /** Reported sample: unqualified constant + this.restTemplate. */
    public List<UserInfoDTO> retrieveChkUserInfo(String id) {
        return this.restTemplate.get(URL_API_CHKUSERINFO , new Obj(), id);
    }
}
