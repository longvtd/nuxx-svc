package com.user.service;

import com.common.rest.WaffulRestTemplete;
import com.user.dto.*;
import java.util.*;

public class V3FqnConstantUserService {
	private final WaffulRestTemplete restTemplate;

	public V3FqnConstantUserService(WaffulRestTemplete r) {
		restTemplate = r;
	}

	@SuppressWarnings("unchecked")
	public List<UserInfoDTO> retrieveFqn(String id) {
		return (List<UserInfoDTO>) restTemplate.get(com.util.ExpApiUriConstant.URL_API_USERINFO_FQN, new Obj(), id);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfoDTO> retrieveFqnThis(String id) {
		return (List<UserInfoDTO>) this.restTemplate.get(com.util.ExpApiUriConstant.URL_API_USERINFO_FQN, new Obj(),
		        id);
	}
}