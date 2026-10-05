package com.user.service;

import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;
import com.user.dto.*;
import java.util.*;

public class V3FqnConstantUserService {
	private final WaffulRestTemplate restTemplate;

	public V3FqnConstantUserService(WaffulRestTemplate r) {
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