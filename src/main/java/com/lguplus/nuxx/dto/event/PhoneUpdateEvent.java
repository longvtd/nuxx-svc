package com.lguplus.nuxx.dto.event;

public class PhoneUpdateEvent {
	private final String phoneId;

	public PhoneUpdateEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}