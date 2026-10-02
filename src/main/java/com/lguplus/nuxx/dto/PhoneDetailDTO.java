package com.lguplus.nuxx.dto;

public class PhoneDetailDTO {
	private String id;
	private String phoneId;
	private String custNm;

	public PhoneDetailDTO(String id, String phoneId) {
		this.id = id;
		this.phoneId = phoneId;
	}

	public String getId() {
		return id;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String name) {
		custNm = name;
	}
}