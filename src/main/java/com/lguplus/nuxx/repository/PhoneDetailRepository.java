package com.lguplus.nuxx.repository;

import java.util.*;
import com.lguplus.nuxx.entity.PhoneDetailEntity;

public class PhoneDetailRepository {
	public List<PhoneDetailEntity> findByPhoneId(String id) {
		return List.of(new PhoneDetailEntity("D-1", id));
	}
}