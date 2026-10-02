package com.lguplus.nuxx.repository;

public class HmOrderNativeQueryRepository {
	public String selectPhoneName(String id) {
		return "phone-" + id;
	}
}