package com.lguplus.nuxx.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.common.rest.ApimRestTemplate;
import com.common.rest.WaffulRestTemplete;
import com.lguplus.nuxx.common.ApiUrlConstants;
import com.lguplus.nuxx.dto.CustDTO;

/**
 * @name: Home customer client Service
 * 
 *        <PRE>
 * 고객 도메인(NUXY-SVC) 외부 API 호출 서비스
 *        </PRE>
 */
@Service
public class HmCustClientService {
	private static final String URL_SELECT_CUST_LIST = "{@nuxy-svc.api-selectCustList-001}";
	private final WaffulRestTemplete restTemplate;
	private final ApimRestTemplate apimRestTemplate;
	private final CustomHttpHelper httpHelper;
	private String sUrl = "{@nuxy-svc.api-selectCust-001}";

	public HmCustClientService(WaffulRestTemplete r, ApimRestTemplate a, CustomHttpHelper h) {
		restTemplate = r;
		apimRestTemplate = a;
		httpHelper = h;
	}

	/** @name: 고객단건조회 */
	public CustDTO selectCustInline(String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectCust-001}", new Object(), id);
	}

	/** @name: 고객단건조회APIM */
	public CustDTO selectCustByApim(String id) {
		String url = "{@nuxy-svc.api-selectCust-001}";
		return (CustDTO) apimRestTemplate.post(url, new Object(), id);
	}

	/** @name: 고객프로필조회 */
	public CustDTO selectCustProfile(String id) {
		return this.selectCustByApim(id);
	}

	/** @name: 고객목록조회 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustList() {
		return (List<CustDTO>) restTemplate.get(URL_SELECT_CUST_LIST, new Object(), "");
	}

	/** @name: 고객저장 */
	public CustDTO saveCust(CustDTO dto) {
		return (CustDTO) apimRestTemplate.post(ApiUrlConstants.SAVE_CUST, dto, "");
	}

	/** @name: 고객목록조회대문자 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustListUpper() {
		return (List<CustDTO>) restTemplate.get("{@NUXY-SVC.api-selectCustList-001}", new Object(), "");
	}

	/** @name: 미등록API호출 */
	public CustDTO selectCustGrade(String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectGrade-999}", new Object(), id);
	}

	/** @name: 미등록도메인호출1 */
	public CustDTO selectPoint(String id) {
		return (CustDTO) restTemplate.get("{@nuxz-svc.api-selectPoint-001}", new Object(), id);
	}

	/** @name: 미등록도메인호출2 */
	public CustDTO selectUnknownDomain(String id) {
		return (CustDTO) restTemplate.get("{@zzzz-svc.api-selectAny-001}", new Object(), id);
	}

	/** @name: URL재할당 */
	public CustDTO selectCustReassigned(String id, boolean list) {
		String url = "{@nuxy-svc.api-selectCust-001}";
		if (list)
			url = "{@nuxy-svc.api-selectCustList-001}";
		return (CustDTO) restTemplate.get(url, new Object(), id);
	}

	/** @name: 동적URL */
	public CustDTO selectCustDynamic(String url, String id) {
		return (CustDTO) restTemplate.get(url, new Object(), id);
	}

	/** @name: URL문자열결합 */
	public CustDTO selectCustConcat(String apiId, String id) {
		return (CustDTO) restTemplate.get("{@nuxy-svc." + apiId + "}", new Object(), id);
	}

	/** @name: 필드URL */
	public CustDTO selectCustByField(String id) {
		return (CustDTO) restTemplate.get(this.sUrl, new Object(), id);
	}

	/** @name: 로컬변수섀도잉 */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustShadow() {
		String sUrl = "{@nuxy-svc.api-selectCustList-001}";
		return (List<CustDTO>) restTemplate.get(sUrl, new Object(), "");
	}

	/** @name: 고객목록조회APIM */
	@SuppressWarnings("unchecked")
	public List<CustDTO> selectCustListByApim() {
		String url = "{@nuxy-svc.api-selectCustList-001}";
		return (List<CustDTO>) apimRestTemplate.get(url, new Object(), "");
	}

	/** @name: 비대상클라이언트 */
	public String callHelper(String id) {
		return httpHelper.post("{@nuxy-svc.api-selectCust-001}", new Object(), id);
	}
}
