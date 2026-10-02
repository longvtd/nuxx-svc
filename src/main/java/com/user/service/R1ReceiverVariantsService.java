package com.user.service;

import com.common.rest.ApimRestTemplate;
import com.common.rest.WaffulRestTemplete;
import com.user.dto.Obj;
import com.user.dto.UserInfoDTO;
import com.util.ExpApiUriConstant;
import java.util.List;

/**
 * R1 - receiver variants: ApimRestTemplate (DO-02, POST/GET) and Wafful field NOT named restTemplate.
 */
public class R1ReceiverVariantsService {

    private final ApimRestTemplate apimRestTemplate;

    private final WaffulRestTemplete userClient; // Wafful client with custom field name

    public R1ReceiverVariantsService(ApimRestTemplate apimRestTemplate, WaffulRestTemplete userClient) {
        this.apimRestTemplate = apimRestTemplate;
        this.userClient = userClient;
    }

    public List<UserInfoDTO> retrieveCustApim(String id) {
        return apimRestTemplate.post(ExpApiUriConstant.URL_API_CUST_INFO, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveCustApimThis(String id) {
        return this.apimRestTemplate.post(ExpApiUriConstant.URL_API_CUST_INFO, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveCustListApim(String id) {
        return this.apimRestTemplate.get(ExpApiUriConstant.URL_API_CUST_LIST, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveUserByCustomFieldName(String id) {
        return userClient.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }

    public List<UserInfoDTO> retrieveUserByCustomFieldNameThis(String id) {
        return this.userClient.get(ExpApiUriConstant.URL_API_USERINFO, new Obj(), id);
    }
}
