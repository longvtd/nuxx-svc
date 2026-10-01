package com.lguplus.nuxx.dto.event;

public class PhoneCreateEvent {

    private final String phoneId;

    public PhoneCreateEvent(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneId() {
        return phoneId;
    }
}
