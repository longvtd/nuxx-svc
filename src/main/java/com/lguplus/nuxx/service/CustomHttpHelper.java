package com.lguplus.nuxx.service;

import org.springframework.stereotype.Component;

/**
 * @name: Custom HTTP helper
 * <PRE>
 * 비대상 HTTP 도우미.
 * WaffulRestTemplate 및 ApimRestTemplate이 아니므로 External API로 추출되지 않아야 합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : CustomHttpHelper.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
@Component
public class CustomHttpHelper {
	/**
	 * @name: 비대상HTTP POST
	 * <PRE>
	 * [OUT-F01] CustomHttpHelper is not WaffulRestTemplate or ApimRestTemplate
	 * URL과 파라미터를 결합한 문자열을 반환합니다.
	 * </PRE>
	 * @MethodName: post
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public String post(String url, Object body, String param) {
		return url + param;
	}

	/**
	 * @name: 비대상HTTP GET
	 * <PRE>
	 * [OUT-F01] CustomHttpHelper is not WaffulRestTemplate or ApimRestTemplate
	 * URL과 파라미터를 결합한 문자열을 반환합니다.
	 * </PRE>
	 * @MethodName: get
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	public String get(String url, Object body, String param) {
		return url + param;
	}
}
