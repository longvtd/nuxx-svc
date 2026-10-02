package com.lguplus.nuxx.service;

import org.springframework.stereotype.Component;

/** Non-RestTemplate helper: must be ignored by external API extraction. */
@Component
public class CustomHttpHelper {
	public String post(String url, Object body, String param) {
		return url + param;
	}

	public String get(String url, Object body, String param) {
		return url + param;
	}
}