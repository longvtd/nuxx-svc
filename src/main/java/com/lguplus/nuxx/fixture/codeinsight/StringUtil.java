package com.lguplus.nuxx.fixture.codeinsight;


/**
 * @name: StringUtil
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: StringUtil.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
public final class StringUtil {
    private StringUtil() { }
    /** @name: equal <PRE>Ordinary null-safe case-sensitive equality; no trimming or normalization.</PRE> @MethodName: equal @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean equal(String left, String right) { return java.util.Objects.equals(left, right); }
    /** @name: notEqual <PRE>Logical complement of ordinary equality.</PRE> @MethodName: notEqual @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean notEqual(String left, String right) { return !equal(left, right); }
    /** @name: isNull <PRE>True only for a null reference.</PRE> @MethodName: isNull @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isNull(Object value) { return value == null; }
    /** @name: isEmpty <PRE>True for null or an empty string; whitespace remains nonempty.</PRE> @MethodName: isEmpty @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isEmpty(String value) { return value == null || value.isEmpty(); }
    /** @name: isNotEmpty <PRE>True only for a nonnull, nonempty string.</PRE> @MethodName: isNotEmpty @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isNotEmpty(String value) { return value != null && !value.isEmpty(); }
}
