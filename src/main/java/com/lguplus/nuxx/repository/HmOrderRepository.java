package com.lguplus.nuxx.repository;

import java.util.*;
import com.lguplus.nuxx.entity.PhoneEntity;

public class HmOrderRepository {
	public List<PhoneEntity> findAllById(List<String> ids) {
		return List.of(new PhoneEntity(ids.get(0), "Y"));
	}

	public PhoneEntity save(PhoneEntity e) {
		return e;
	}
}