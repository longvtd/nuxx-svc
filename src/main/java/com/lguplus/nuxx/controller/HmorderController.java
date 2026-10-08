package com.lguplus.nuxx.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.PhoneReqDTO;
import com.lguplus.nuxx.service.HmOrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: HomeOrderController
 * <PRE>
 * REST controller for home-order phone order APIs.
 * Delegates list, retrieve, save and change requests to HmOrderService.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmorderController.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@RestController
@Tag(
    name = "home order API",
    description = "홈주문 휴대폰 주문 API"
)
@RequestMapping("/hmorder")
public class HmorderController {
	private final HmOrderService service;

	/**
	 * @name: 홈주문컨트롤러생성
	 * <PRE>
	 * 홈주문 서비스 의존성을 주입합니다.
	 * </PRE>
	 * @MethodName: HmorderController
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public HmorderController(HmOrderService s) {
		service = s;
	}

	/**
	 * @name: 휴대폰주문목록조회
	 * <PRE>
	 * 요청 DTO의 식별자를 사용하여 휴대폰 주문 목록을 조회합니다.
	 * </PRE>
	 * @MethodName: retrievePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "휴대폰주문목록조회",
	    description = "요청 조건으로 휴대폰 주문 목록을 조회합니다."
	)
	@GetMapping("/phone/v1/list")
	public List<PhoneDTO> retrievePhone(@ParameterObject PhoneReqDTO q) {
		return service.retrievePhone(q);
	}

	/**
	 * @name: 휴대폰주문단건조회
	 * <PRE>
	 * 휴대폰 식별자를 사용하여 휴대폰 주문 정보를 조회합니다.
	 * </PRE>
	 * @MethodName: retrievePhoneById
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "휴대폰주문단건조회",
	    description = "휴대폰 식별자로 주문 정보를 조회합니다."
	)
	@GetMapping("/phone/v1/{phoneId}")
	public List<PhoneDTO> retrievePhoneById(@PathVariable("phoneId") String id) {
		return service.retrievePhone(id);
	}

	/**
	 * @name: 휴대폰주문저장
	 * <PRE>
	 * 휴대폰 주문을 검증하고 고객 정보와 상세를 반영한 뒤 저장 처리를 수행합니다.
	 * </PRE>
	 * @MethodName: savePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "휴대폰주문저장",
	    description = "휴대폰 주문 저장 처리를 수행합니다."
	)
	@PostMapping("/phone/v1/save")
	public void savePhone(@ParameterObject PhoneReqDTO q) {
		service.savePhone(q);
	}

	/**
	 * @name: 휴대폰주문변경
	 * <PRE>
	 * 조회된 휴대폰 주문에 고객 정보를 반영하여 변경합니다.
	 * </PRE>
	 * @MethodName: changePhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "휴대폰주문변경",
	    description = "조회된 휴대폰 주문을 변경합니다."
	)
	@PostMapping("/phone/v1/change")
	public String changePhone(@ParameterObject PhoneReqDTO q) {
		return service.changePhone(service.retrievePhone(q));
	}
	
	/**
	 * @name: Create new order detail phone
	 * <PRE>
	 * Create new order detail phone
	 * </PRE>
	 * @MethodName: savePhoneDetail
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order detail phone",
	    description = "Create new order detail phone"
	)
	@PostMapping("/phone/v1/createOrderDetail")
	public void savePhoneDetail(@ParameterObject List<PhoneDTO> q) {
		service.createOrderDetail(q);
	}
	
	/**
	 * @name: Create new order iphone
	 * <PRE>
	 * Create new order iphone
	 * </PRE>
	 * @MethodName: savePhoneDetail
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order iphone",
	    description = "Create new order iphone"
	)
	@PostMapping("/phone/v1/createOrderPhone")
	public void createOrderPhone(@ParameterObject List<PhoneDTO> q) {
		service.createOrderPhone(q);
	}
	
	/**
	 * @name: Create new order laptop
	 * <PRE>
	 * Create new order laptop
	 * </PRE>
	 * @MethodName: createOrderLaptop
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order laptop",
	    description = "Create new order laptop"
	)
	@PostMapping("/phone/v1/createOrderLaptop")
	public void createOrderLaptop(@ParameterObject List<PhoneDTO> q) {
		service.createOrderLaptop(q);
	}
	
	/**
	 * @name: Create new order PC
	 * <PRE>
	 * Create new order PC
	 * </PRE>
	 * @MethodName: createOrderPc
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order PC",
	    description = "Create new order PC"
	)
	@PostMapping("/phone/v1/createOrderPc")
	public void createOrderPc(@ParameterObject List<PhoneDTO> q) {
		service.createOrderPc(q);
	}
	
	/**
	 * @name: Create new order headphone
	 * <PRE>
	 * Create new order headphone
	 * </PRE>
	 * @MethodName: createOrderHeadPhone
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order HeadPhone",
	    description = "Create new order HeadPhone"
	)
	@PostMapping("/phone/v1/createOrderHeadPhone")
	public void createOrderHeadPhone(@ParameterObject List<PhoneDTO> listHeadPhone) {
		service.createOrderHeadPhone(listHeadPhone);
	}
	
	/**
	 * @name: Create new order Ipad
	 * <PRE>
	 * Create new order Ipad
	 * </PRE>
	 * @MethodName: createOrderIpad
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order HeadPhone",
	    description = "Create new order HeadPhone"
	)
	@PostMapping("/phone/v1/createOrderIpad")
	public void createOrderIpad(@ParameterObject List<PhoneDTO> listIpad) {
		service.createOrderIpad(listIpad);
	}
	
	/**
	 * @name: Create new order Tablet
	 * <PRE>
	 * Create new order Tablet
	 * </PRE>
	 * @MethodName: createOrderTablet
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "Create new order Tablet",
	    description = "Create new order Tablet"
	)
	@PostMapping("/phone/v1/createOrderTablet")
	public void createOrderTablet(@ParameterObject List<PhoneDTO> listTablet) {
		service.createOrderTablet(listTablet);
	}

	/**
	 * @name: Create bulk phone orders
	 * <PRE>
	 * 여러 휴대폰 주문의 일괄 생성을 서비스에 위임합니다.
	 * </PRE>
	 * @MethodName: createOrderBulk
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 08. 21:00:00
	 */
	@Operation(
	    summary = "Create bulk phone orders",
	    description = "여러 휴대폰 주문을 일괄 생성합니다."
	)
	@PostMapping("/phone/v1/createOrderBulk")
	public void createOrderBulk(@ParameterObject List<PhoneDTO> values) {
		service.createOrderBulk(values);
	}
}
