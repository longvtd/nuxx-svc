package com.lguplus.nuxx.common;

/**
 * @name: API URL constants
 * <PRE>
 * 고객 연계 External API placeholder 상수 목록.
 * 저장 및 FQN 조회용 도메인 API 식별자를 제공합니다.
 * </PRE>
 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
 * @class  : ApiUrlConstants.java
 * @Date   : 2026. 10. 02.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *   1.  2026. 10. 02.     21:00:00.        LongVTD.            Initial creation
 * </PRE>
 */
public final class ApiUrlConstants {
	/**
	 * @name: 상수클래스생성차단
	 * <PRE>
	 * 인스턴스 생성을 방지합니다.
	 * </PRE>
	 * @MethodName: ApiUrlConstants
	 * @Part: 차세대 아키텍처
	 * @author: Vo Tran Dinh Long (longvtd@lgupluspartners.co.kr)
	 * @ModifiedDate: 2026. 10. 02. 21:00:00
	 */
	private ApiUrlConstants() {
	}

	public static final String SAVE_CUST = "{@nuxy-svc.saveCust-001}";
	public static final String USER_FQN = "{@nuxy-svc.api-selectUserFqn-001}";
}
