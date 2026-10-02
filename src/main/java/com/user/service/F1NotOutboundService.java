package com.user.service;

import com.util.ExpApiUriConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * F1-F3 - constant used but NOT in an outbound Wafful/Apim call. Expect NO ExternalApi edge.
 */
public class F1NotOutboundService {

    /** Local class with get(...) - not WaffulRestTemplete/ApimRestTemplate. */
    static class FakeTemplate {
        public List<Object> get(String url, Object body, Object... params) {
            return List.of();
        }
    }

    private final Map<String, Object> cache = new HashMap<>();

    private final FakeTemplate restTemplate = new FakeTemplate(); // same name, different type

    /** F1 - constant as map key. */
    public Object readCacheByConstant() {
        return cache.get(ExpApiUriConstant.URL_API_USERINFO);
    }

    /** F2 - constant in a log string. */
    public String logConstant() {
        return "calling " + ExpApiUriConstant.URL_API_CHKUSERINFO;
    }

    /** F3 - field named restTemplate but unrelated type. */
    public List<Object> fakeTemplateCall(String id) {
        return this.restTemplate.get(ExpApiUriConstant.URL_API_USERINFO, new Object(), id);
    }
}
