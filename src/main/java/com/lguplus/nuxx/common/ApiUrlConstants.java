package com.lguplus.nuxx.common;

/**
 * @name: 외부 API URL 상수
 * <PRE>
 * 타 도메인 API 호출 URL placeholder 상수
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : ApiUrlConstants.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
public final class ApiUrlConstants {

    /*
     * 고객 도메인 (NUXY-SVC)
     */
    public static final String SAVE_CUST = "{@nuxy-svc.saveCust-001}"; //고객 저장
    public static final String SELECT_CUST = "{@nuxy-svc.api-selectCust-001}"; //고객 단건 조회

    private ApiUrlConstants() {
    }
}
