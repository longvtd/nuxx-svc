package com.lguplus.nuxx.controller;

import java.util.*;
import com.lguplus.nuxx.dto.*;
import com.lguplus.nuxx.service.HmOrderService;
import org.springframework.web.bind.annotation.*;
import org.springdoc.core.annotations.ParameterObject;

@RestController
@RequestMapping("/hmorder")
public class HmorderController {
	private final HmOrderService service;

	public HmorderController(HmOrderService s) {
		service = s;
	}

	@GetMapping("/phone/v1/list")
	public List<PhoneDTO> retrievePhone(@ParameterObject PhoneReqDTO q) {
		return service.retrievePhone(q);
	}

	@GetMapping("/phone/v1/{phoneId}")
	public List<PhoneDTO> retrievePhoneById(@PathVariable("phoneId") String id) {
		return service.retrievePhone(id);
	}

	@PostMapping("/phone/v1/save")
	public void savePhone(@ParameterObject PhoneReqDTO q) {
		service.savePhone(q);
	}

	@PostMapping("/phone/v1/change")
	public String changePhone(@ParameterObject PhoneReqDTO q) {
		return service.changePhone(service.retrievePhone(q));
	}
}