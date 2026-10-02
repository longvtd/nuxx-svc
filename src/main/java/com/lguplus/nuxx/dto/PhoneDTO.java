package com.lguplus.nuxx.dto;

import java.util.*;
import com.lguplus.nuxx.entity.PhoneEntity;

public class PhoneDTO {
	private final String id;
	private final String useYn;

	public PhoneDTO(String id, String useYn) {
		this.id = id;
		this.useYn = useYn;
	}

	public String getId() {
		return id;
	}

	public String getUseYn() {
		return useYn;
	}

	public PhoneEntity toEntity() {
		return new PhoneEntity(id, useYn);
	}

	public static List<PhoneDTO> fromEntities(List<PhoneEntity> es) {
		List<PhoneDTO> r = new ArrayList<>();
		for (PhoneEntity e : es)
			r.add(new PhoneDTO(e.getId(), e.getUseYn()));
		return r;
	}
}