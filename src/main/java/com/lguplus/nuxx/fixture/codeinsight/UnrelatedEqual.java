package com.lguplus.nuxx.fixture.codeinsight;


/**
 * @name: UnrelatedEqual
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: UnrelatedEqual.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
public final class UnrelatedEqual {
    private UnrelatedEqual() { }
    /** @name: equal <PRE>Case-insensitive comparison; deliberately not ordinary StringUtil equality.</PRE> @MethodName: equal @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean equal(String left, String right) {
        return left != null && right != null && left.equalsIgnoreCase(right);
    }
}
