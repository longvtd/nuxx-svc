package com.util;

import com.common.rest.WaffulRestTemplete;

/** V7b - parent class; subclasses use inherited constant and field. */
public abstract class BaseApiClient {

    protected static final String URL_API_USER_PARENT = "{@nuxy-svc.api-selectUserParent-001}"; // api user via parent

    protected final WaffulRestTemplete restTemplate;

    protected BaseApiClient(WaffulRestTemplete restTemplate) {
        this.restTemplate = restTemplate;
    }
}
