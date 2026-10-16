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

    /** @name: isBlank <PRE>True for null, empty or only Java isWhitespace code points.</PRE> @MethodName: isBlank @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isBlank(String value) { return value == null || value.isBlank(); }
    /** @name: isNotBlank <PRE>True for nonnull text containing a non-whitespace code point.</PRE> @MethodName: isNotBlank @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isNotBlank(String value) { return value != null && !value.isBlank(); }
    /** @name: equalsIgnoreCase <PRE>Null-safe Java case-insensitive equality; no trimming or normalization.</PRE> @MethodName: equalsIgnoreCase @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean equalsIgnoreCase(String left, String right) { return left == null ? right == null : left.equalsIgnoreCase(right); }
    /** @name: in <PRE>Case-sensitive membership of argument 0 in argument 1; null array false, null element can match null.</PRE> @MethodName: in @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean in(String value, String[] allowed) { if (allowed == null) return false; for (String item : allowed) if (java.util.Objects.equals(value, item)) return true; return false; }
    /** @name: containsAny <PRE>Case-sensitive substring match of any nonnull fragment in argument 1; null inputs false, empty fragment matches.</PRE> @MethodName: containsAny @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean containsAny(String value, String[] fragments) { if (value == null || fragments == null) return false; for (String fragment : fragments) if (fragment != null && value.contains(fragment)) return true; return false; }
    /** @name: trim <PRE>Return Java trim (characters through U+0020 at ends); null stays null.</PRE> @MethodName: trim @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String trim(String value) { return value == null ? null : value.trim(); }
    /** @name: upperCase <PRE>Return Locale.ROOT uppercase text; null stays null.</PRE> @MethodName: upperCase @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String upperCase(String value) { return value == null ? null : value.toUpperCase(java.util.Locale.ROOT); }
    /** @name: lowerCase <PRE>Return Locale.ROOT lowercase text; null stays null.</PRE> @MethodName: lowerCase @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String lowerCase(String value) { return value == null ? null : value.toLowerCase(java.util.Locale.ROOT); }
    /** @name: defaultIfEmpty <PRE>Return argument 1 only when argument 0 is null or empty; whitespace retained; fallback may be null.</PRE> @MethodName: defaultIfEmpty @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String defaultIfEmpty(String value, String fallback) { return value == null || value.isEmpty() ? fallback : value; }
    /** @name: normaliseCode <PRE>Trim, uppercase with Locale.ROOT and remove ASCII hyphens only; null stays null.</PRE> @MethodName: normaliseCode @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String normaliseCode(String value) { return value == null ? null : value.trim().toUpperCase(java.util.Locale.ROOT).replace("-", ""); }
    /** @name: isEmpty <PRE>CharSequence overload: null or length zero is empty; whitespace retained.</PRE> @MethodName: isEmpty @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isEmpty(CharSequence value) { return value == null || value.length() == 0; }
    /** @name: equal <PRE>Argument 2 selects null-safe case-insensitive versus ordinary equality; no trimming.</PRE> @MethodName: equal @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean equal(String left, String right, boolean ignoreCase) { return ignoreCase ? equalsIgnoreCase(left, right) : equal(left, right); }
}
