package com.lguplus.nuxx.dto.event;

public class PhoneCreateEvent {
	private final String phoneId;

	public PhoneCreateEvent(String id) {
		phoneId = id;
	}

	public String getPhoneId() {
		return phoneId;
	}
}