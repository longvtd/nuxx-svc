package com.lguplus.nuxx.dto;

public class CustDTO {
	private String custId;
	private String custNm;

	public CustDTO() {
	}

	public CustDTO(String id, String name) {
		custId = id;
		custNm = name;
	}

	public String getCustId() {
		return custId;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String v) {
		custNm = v;
	}
}