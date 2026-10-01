package com.lguplus.nuxx.dto.event;

public class PhoneUpdateEvent {

    private final String phoneId;

    public PhoneUpdateEvent(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneId() {
        return phoneId;
    }
}
