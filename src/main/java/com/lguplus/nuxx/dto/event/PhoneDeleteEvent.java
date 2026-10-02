package com.lguplus.nuxx.dto.event;

public class PhoneDeleteEvent {
	private final String phoneId;

	public PhoneDeleteEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}