package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: TechnicalUtil
 * <PRE>Representative synthetic utility with explicit contracts; no security source claimed.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: TechnicalUtil.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class TechnicalUtil {
    private TechnicalUtil() { }
    /** @name: correlationLength <PRE>Pure technical UTF-16 correlation-token length; null returns zero; no business action or logging.</PRE> @MethodName: correlationLength @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static int correlationLength(String correlation) { return correlation == null ? 0 : correlation.length(); }
}
