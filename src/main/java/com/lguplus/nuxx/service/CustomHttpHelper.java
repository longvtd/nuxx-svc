package com.lguplus.nuxx.service;

import org.springframework.stereotype.Component;

/**
 * 사내 HTTP 헬퍼 (RestTemplate 계열 아님: 외부 API 추출 대상 아님)
 */
@Component
public class CustomHttpHelper {

    public String post(String url, Object body, String param) {
        return url + param;
    }

    public String get(String url, Object body, String param) {
        return url + param;
    }
}
