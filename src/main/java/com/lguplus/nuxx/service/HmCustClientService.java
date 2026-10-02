package com.lguplus.nuxx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.common.rest.ApimRestTemplate;
import com.common.rest.WaffulRestTemplete;
import com.lguplus.nuxx.common.ApiUrlConstants;
import com.lguplus.nuxx.dto.CustDTO;

/**
 * @name: Home customer client Service
 * <PRE>
 * 고객 도메인 외부 API 호출 서비스.
 * Wafful 및 APIM 경로와 미해결 URL 시나리오를 제공합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : HmCustClientService.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Service
public class HmCustClientService {
	private static final String URL_SELECT_CUST_LIST = "{@nuxy-svc.api-selectCustList-001}";
	private final WaffulRestTemplete restTemplate;
	private final ApimRestTemplate apimRestTemplate;
	private final CustomHttpHelper httpHelper;
	private String sUrl = "{@nuxy-svc.api-selectCust-001}";

	/**
	 * @name: 고객클라이언트서비스생성
	 * <PRE>
	 * Wafful, APIM, 비대상 HTTP 도우미 의존성을 주입합니다.
	 * </PRE>
	 * @MethodName: HmCustClientService
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public HmCustClientService(WaffulRestTemplete r, ApimRestTemplate a, CustomHttpHelper h) {
		restTemplate = r;
		apimRestTemplate = a;
		httpHelper = h;
	}

	/**
	 * @name: 고객단건조회
	 * <PRE>
	 * [OUT-01] inline literal / Wafful / HIGH
	 * </PRE>
	 * @MethodName: selectCustInline
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustInline(String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectCust-001}", new Object(), id);
	}

	/**
	 * @name: 고객단건조회APIM
	 * <PRE>
	 * [OUT-02] local variable literal / APIM / HIGH
	 * </PRE>
	 * @MethodName: selectCustByApim
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustByApim(String id) {
		String url = "{@nuxy-svc.api-selectCust-001}";
		return (CustDTO) apimRestTemplate.post(url, new Object(), id);
	}

	/**
	 * @name: 고객프로필조회
	 * <PRE>
	 * [OUT-03] contextual APIM call via selectCustByApim / HIGH
	 * </PRE>
	 * @MethodName: selectCustProfile
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustProfile(String id) {
		return this.selectCustByApim(id);
	}

	/**
	 * @name: 고객목록조회
	 * <PRE>
	 * [OUT-04] static final same-class constant / Wafful / HIGH
	 * </PRE>
	 * @MethodName: selectCustList
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustList() {
		return (List<CustDTO>) restTemplate.get(URL_SELECT_CUST_LIST, new Object(), "");
	}

	/**
	 * @name: 고객저장
	 * <PRE>
	 * [OUT-05] external constant / APIM / HIGH
	 * </PRE>
	 * @MethodName: saveCust
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO saveCust(CustDTO dto) {
		return (CustDTO) apimRestTemplate.post(ApiUrlConstants.SAVE_CUST, dto, "");
	}

	/**
	 * @name: 고객목록조회대문자도메인
	 * <PRE>
	 * [OUT-06] uppercase domain placeholder normalization / HIGH
	 * </PRE>
	 * @MethodName: selectCustListUpper
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustListUpper() {
		return (List<CustDTO>) restTemplate.get("{@NUXY-SVC.api-selectCustList-001}", new Object(), "");
	}

	/**
	 * @name: 미등록고객등급조회
	 * <PRE>
	 * [OUT-N01] API not registered in domain-api.yml / unresolved
	 * </PRE>
	 * @MethodName: selectCustGrade
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustGrade(String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectGrade-999}", new Object(), id);
	}

	/**
	 * @name: 포인트조회
	 * <PRE>
	 * [OUT-07] registered secondary domain API / HIGH
	 * </PRE>
	 * @MethodName: selectPoint
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectPoint(String id) {
		return (CustDTO) restTemplate.get("{@nuxz-svc.api-selectPoint-001}", new Object(), id);
	}

	/**
	 * @name: 미등록도메인조회
	 * <PRE>
	 * [OUT-N02] domain not registered in domain.yml / unresolved
	 * </PRE>
	 * @MethodName: selectUnknownDomain
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectUnknownDomain(String id) {
		return (CustDTO) restTemplate.get("{@zzzz-svc.api-selectAny-001}", new Object(), id);
	}

	/**
	 * @name: 고객URL재할당조회
	 * <PRE>
	 * [OUT-N03] reassigned local URL / unresolved or bounded diagnostic
	 * </PRE>
	 * @MethodName: selectCustReassigned
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustReassigned(String id, boolean list) {
		String url = "{@nuxy-svc.api-selectCust-001}";
		if (list)
			url = "{@nuxy-svc.api-selectCustList-001}";
		return (CustDTO) restTemplate.get(url, new Object(), id);
	}

	/**
	 * @name: 동적URL고객조회
	 * <PRE>
	 * [OUT-N04] URL from method parameter / unresolved
	 * </PRE>
	 * @MethodName: selectCustDynamic
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustDynamic(String url, String id) {
		return (CustDTO) restTemplate.get(url, new Object(), id);
	}

	/**
	 * @name: 문자열결합고객조회
	 * <PRE>
	 * [OUT-N05] runtime concatenated URL / unresolved
	 * </PRE>
	 * @MethodName: selectCustConcat
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustConcat(String apiId, String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc." + apiId + "}", new Object(), id);
	}

	/**
	 * @name: 필드URL고객조회
	 * <PRE>
	 * [OUT-N06] mutable instance field URL / unresolved
	 * </PRE>
	 * @MethodName: selectCustByField
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public CustDTO selectCustByField(String id) {
		return (CustDTO) restTemplate.get(this.sUrl, new Object(), id);
	}

	/**
	 * @name: 로컬URL섀도잉고객조회
	 * <PRE>
	 * [OUT-08] local literal shadows instance field / expected local resolution
	 * </PRE>
	 * @MethodName: selectCustShadow
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustShadow() {
		String sUrl = "{@nuxy-svc.api-selectCustList-001}";
		return (List<CustDTO>) restTemplate.get(sUrl, new Object(), "");
	}

	/**
	 * @name: 고객목록조회APIM
	 * <PRE>
	 * [OUT-09] local variable literal / APIM / HIGH
	 * </PRE>
	 * @MethodName: selectCustListByApim
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustListByApim() {
		String url = "{@nuxy-svc.api-selectCustList-001}";
		return (List<CustDTO>) apimRestTemplate.get(url, new Object(), "");
	}

	/**
	 * @name: 비대상HTTP도우미호출
	 * <PRE>
	 * [OUT-F01] CustomHttpHelper is not WaffulRestTemplete or ApimRestTemplate
	 * </PRE>
	 * @MethodName: callHelper
	 * @Part: 차세대 아키텍처
	 * @author: Tester (tester@example.local)
	 * @ModifiedDate: 2026. 10. 01. 09:00:00
	 */
	public String callHelper(String id) {
		return httpHelper.post("{@nuxy-svc.api-selectCust-001}", new Object(), id);
	}
}
