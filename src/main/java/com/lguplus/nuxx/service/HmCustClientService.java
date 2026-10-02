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
 * 고객 도메인(NUXY-SVC) 외부 API 호출 서비스
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : HmCustClientService.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
@Service
public class HmCustClientService {

    /* 동일 클래스 static final 상수 */
    private static final String URL_SELECT_CUST_LIST = "{@nuxy-svc.api-selectCustList-001}"; //고객 목록 조회 URL

    private final WaffulRestTemplete restTemplate;
    private final ApimRestTemplate apimRestTemplate;
    private final CustomHttpHelper httpHelper;
    private String sUrl = "{@nuxy-svc.api-selectCust-001}";

    public HmCustClientService(WaffulRestTemplete restTemplate, ApimRestTemplate apimRestTemplate,
            CustomHttpHelper httpHelper) {
        this.restTemplate = restTemplate;
        this.apimRestTemplate = apimRestTemplate;
        this.httpHelper = httpHelper;
    }

    /**
     * @name: 고객단건조회
     * <PRE>
     * [OUT-01] inline literal / DIRECT / HIGH
     * </PRE>
     * @MethodName: selectCustInline
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustInline(String custId) {
        return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectCust-001}", new Object(), custId);
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
    public CustDTO selectCustByApim(String custId) {
        String sUrl = "{@nuxy-svc.api-selectCust-001}";
        return (CustDTO) apimRestTemplate.post(sUrl, new Object(), custId);
    }
    /**
     * @name: 고객프로필조회
     * <PRE>
     * 고객 단건 정보를 APIM 외부 API를 통해 조회
     * </PRE>
     * @MethodName: selectCustProfile
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 02. 19:30:00
     */
    public CustDTO selectCustProfile(String custId) {
        return this.selectCustByApim(custId);
    }
    /**
     * @name: 고객목록조회
     * <PRE>
     * [OUT-03] same-class static final / DIRECT / HIGH
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
     * [OUT-04] other-class constant (ApiUrlConstants) / APIM / HIGH / apiId without api- prefix
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
     * @name: 고객목록조회대문자
     * <PRE>
     * [OUT-05] upper-case domain id / case-insensitive / HIGH
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
     * @name: 미등록API호출
     * <PRE>
     * [OUT-06] apiId not in domain-api.yml / MEDIUM / API_NOT_REGISTERED
     * </PRE>
     * @MethodName: selectCustGrade
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustGrade(String custId) {
        return (CustDTO) restTemplate.get("{@nuxy-svc.api-selectGrade-999}", new Object(), custId);
    }

    /**
     * @name: 미등록도메인호출1
     * <PRE>
     * [OUT-07] domain only in domain-api.yml, not in domain.yml / MEDIUM / DOMAIN_NOT_REGISTERED
     * </PRE>
     * @MethodName: selectPoint
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectPoint(String custId) {
        return (CustDTO) restTemplate.get("{@nuxz-svc.api-selectPoint-001}", new Object(), custId);
    }

    /**
     * @name: 미등록도메인호출2
     * <PRE>
     * [OUT-08] domain in neither file / MEDIUM / DOMAIN_NOT_REGISTERED
     * </PRE>
     * @MethodName: selectUnknownDomain
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectUnknownDomain(String custId) {
        return (CustDTO) restTemplate.get("{@zzzz-svc.api-selectAny-001}", new Object(), custId);
    }

    /**
     * @name: URL재할당
     * <PRE>
     * [OUT-09] local variable reassigned before call / UNRESOLVED
     * </PRE>
     * @MethodName: selectCustReassigned
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustReassigned(String custId, boolean useList) {
        String url = "{@nuxy-svc.api-selectCust-001}";
        if (useList) {
            url = "{@nuxy-svc.api-selectCustList-001}";
        }
        return (CustDTO) restTemplate.get(url, new Object(), custId);
    }

    /**
     * @name: 동적URL
     * <PRE>
     * [OUT-10] URL from method parameter / UNRESOLVED
     * </PRE>
     * @MethodName: selectCustDynamic
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustDynamic(String url, String custId) {
        return (CustDTO) restTemplate.get(url, new Object(), custId);
    }

    /**
     * @name: URL문자열결합
     * <PRE>
     * [OUT-11] string concatenation / UNRESOLVED
     * </PRE>
     * @MethodName: selectCustConcat
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustConcat(String apiId, String custId) {
        return (CustDTO) restTemplate.get("{@nuxy-svc." + apiId + "}", new Object(), custId);
    }

    /**
     * @name: 필드URL
     * <PRE>
     * [OUT-12] non-final instance field / UNRESOLVED
     * </PRE>
     * @MethodName: selectCustByField
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public CustDTO selectCustByField(String custId) {
        return (CustDTO) restTemplate.get(this.sUrl, new Object(), custId);
    }

    /**
     * @name: 로컬변수섀도잉
     * <PRE>
     * [OUT-13] local variable shadows field / resolves LOCAL value selectCustList / HIGH
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
     * [OUT-15] local variable / APIM GET / HIGH
     * </PRE>
     * @MethodName: selectCustListByApim
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    @SuppressWarnings("unchecked")
    public List<CustDTO> selectCustListByApim() {
        String sUrl = "{@nuxy-svc.api-selectCustList-001}";
        return (List<CustDTO>) apimRestTemplate.get(sUrl, new Object(), "");
    }

    /**
     * @name: 비대상클라이언트
     * <PRE>
     * [OUT-14] non-RestTemplate type with same method name / IGNORED
     * </PRE>
     * @MethodName: callHelper
     * @Part: 차세대 아키텍처
     * @author: Tester (tester@example.local)
     * @ModifiedDate: 2026. 10. 01. 09:00:00
     */
    public String callHelper(String custId) {
        return httpHelper.post("{@nuxy-svc.api-selectCust-001}", new Object(), custId);
    }
}
