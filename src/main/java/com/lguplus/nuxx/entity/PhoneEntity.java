package com.lguplus.nuxx.entity;

public class PhoneEntity {
	private String id, useYn, name;

	public PhoneEntity(String id, String useYn) {
		this.id = id;
		this.useYn = useYn;
	}

	public String getId() {
		return id;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setName(String v) {
		name = v;
	}

	public String getName() {
		return name;
	}
}