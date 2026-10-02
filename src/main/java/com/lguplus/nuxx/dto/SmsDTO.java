package com.lguplus.nuxx.dto;

public class SmsDTO {
	private final String id;
	private final int count;

	public SmsDTO(String id, int count) {
		this.id = id;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public int getCount() {
		return count;
	}
}