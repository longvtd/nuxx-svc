package com.lguplus.nuxx.entity;

public class PhoneDetailEntity {
	private final String id, phoneId;

	public PhoneDetailEntity(String id, String phoneId) {
		this.id = id;
		this.phoneId = phoneId;
	}

	public String getId() {
		return id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}