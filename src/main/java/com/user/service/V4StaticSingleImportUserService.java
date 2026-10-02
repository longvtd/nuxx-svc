package com.user.service;

import static com.util.ExpApiUriConstant.URL_API_CHKUSERINFO;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import java.util.List;

/**
 * V4 - single static import of URL_API_CHKUSERINFO.
 */
public class V4StaticSingleImportUserService {

    private final WaffulRestTemplete restTemplate;

    public V4StaticSingleImportUserService(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfoDTO> retrieveChkUserInfo(String id) {
        return this.restTemplate.get(URL_API_CHKUSERINFO , new Obj(), id);
    }

    public List<UserInfoDTO> retrieveChkUserInfoNoThis(String id) {
        return restTemplate.get(URL_API_CHKUSERINFO, new Obj(), id);
    }
}
