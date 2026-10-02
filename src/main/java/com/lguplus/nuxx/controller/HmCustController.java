package com.lguplus.nuxx.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.service.HmCustClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: HomeCustomerController
 * <PRE>
 * REST controller for home-order customer integration.
 * Delegates customer lookup requests to HmCustClientService.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmCustController.java
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
    name = "home customer API",
    description = "홈주문 고객 연계 API"
)
@RequestMapping("/api/v1/customer")
public class HmCustController {
	private final HmCustClientService custClient;

	/**
	 * @name: 홈고객컨트롤러생성
	 * <PRE>
	 * 고객 연계 서비스 의존성을 주입합니다.
	 * </PRE>
	 * @MethodName: HmCustController
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public HmCustController(HmCustClientService custClient) {
		this.custClient = custClient;
	}

	/**
	 * @name: 고객단건조회
	 * <PRE>
	 * 고객 식별자를 사용하여 고객 도메인의 단건 고객 정보를 조회합니다.
	 * </PRE>
	 * @MethodName: selectCust
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "고객단건조회",
	    description = "고객 도메인에서 고객 정보를 조회합니다."
	)
	@GetMapping("/v1/{custId}")
	public CustDTO selectCust(@PathVariable("custId") String custId) {
		return custClient.selectCustInline(custId);
	}

	/**
	 * @name: 고객단건조회APIM
	 * <PRE>
	 * APIM 경로로 고객 식별자에 해당하는 단건 고객 정보를 조회합니다.
	 * </PRE>
	 * @MethodName: selectCustByApim
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "고객단건조회APIM",
	    description = "APIM을 통해 고객 정보를 조회합니다."
	)
	@GetMapping("/v1/apim/{custId}")
	public CustDTO selectCustByApim(@PathVariable("custId") String custId) {
		return custClient.selectCustByApim(custId);
	}

	/**
	 * @name: 고객프로필조회
	 * <PRE>
	 * 고객 프로필 조회를 위해 기존 APIM 고객 조회를 재사용합니다.
	 * </PRE>
	 * @MethodName: selectCustProfile
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "고객프로필조회",
	    description = "고객 프로필 조회를 위해 APIM 고객 조회를 호출합니다."
	)
	@GetMapping("/v1/profile/{custId}")
	public CustDTO selectCustProfile(@PathVariable("custId") String custId) {
		return custClient.selectCustProfile(custId);
	}

	/**
	 * @name: 고객목록조회
	 * <PRE>
	 * 고객 도메인의 고객 목록을 조회합니다.
	 * </PRE>
	 * @MethodName: selectCustList
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	@Operation(
	    summary = "고객목록조회",
	    description = "고객 도메인에서 고객 목록을 조회합니다."
	)
	@GetMapping("/v1/list")
	public List<CustDTO> selectCustList() {
		return custClient.selectCustList();
	}
}
