package com.util;

/**
 * Outbound API URL constants. Placeholder {@domain_id.url_id} resolved via domain.yml + domain-api.yml.
 */
public class ExpApiUriConstant {

    private ExpApiUriConstant() {
    }

    // V2 - ExpApiUriConstant.URL_API_USERINFO
    public static final String URL_API_USERINFO = "{@nuxy-svc.api-selectUser-001}"; // api get list User

    // V4 / V5 - static import (sample goc)
    public static final String URL_API_CHKUSERINFO = "{@nuxy-svc.api-selectUserList-001}"; // api check list User

    // V3 - com.util.ExpApiUriConstant.URL_API_USERINFO_FQN
    public static final String URL_API_USERINFO_FQN = "{@nuxy-svc.api-selectUserFqn-001}"; // api user FQN

    // V5 - wildcard static import
    public static final String URL_API_USER_WILDCARD = "{@nuxy-svc.api-selectUserWildcard-001}"; // api user wildcard

    // V8 - chain: this -> ExpApiUriBaseConstant.BASE_USER_CHAIN -> ExpApiUriChainLeafConstant.LEAF_USER_CHAIN
    public static final String URL_API_USER_CHAIN = ExpApiUriBaseConstant.BASE_USER_CHAIN; // api user chain

    // R1 - DO-02 via ApimRestTemplate
    public static final String URL_API_CUST_INFO = "{@nuxz-svc.selectCust-001}"; // api select customer
    public static final String URL_API_CUST_LIST = "{@nuxz-svc.selectCustList-001}"; // api select customer list

    // C1 - uppercase domain id in placeholder, same API as URL_API_USERINFO
    public static final String URL_API_USERINFO_UPPER = "{@nuxy-svc.api-selectUser-001}"; // api get User (uppercase)

    // N4 - NOT final -> must NOT be resolved
    public static String URL_API_NOT_FINAL = "{@nuxy-svc.api-selectUserNotFinal-001}";

    // N6 - placeholder not registered in domain-api.yml
    public static final String URL_API_NOT_IN_CATALOG = "{@nuxy-svc.api-notExist-999}";

    // N7 - domain not registered in domain.yml
    public static final String URL_API_UNKNOWN_DOMAIN = "{@do-99.api-selectUser-001}";
}
