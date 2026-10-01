package com.lguplus.nuxx.dto.event;

public class PhoneDeleteEvent {

    private final String phoneId;

    public PhoneDeleteEvent(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneId() {
        return phoneId;
    }
}
