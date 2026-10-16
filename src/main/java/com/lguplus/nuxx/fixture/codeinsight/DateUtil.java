package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: DateUtil
 * <PRE>Representative synthetic utility with explicit contracts; no security source claimed.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: DateUtil.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class DateUtil {
    private DateUtil() { }
    /** @name: isDate <PRE>Strict LocalDate validation using explicit Locale.ROOT pattern; null/invalid value or pattern false; sample pattern uuuu-MM-dd.</PRE> @MethodName: isDate @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isDate(String value, String pattern) { if (value == null || pattern == null) return false; try { java.time.LocalDate.parse(value, java.time.format.DateTimeFormatter.ofPattern(pattern, java.util.Locale.ROOT).withResolverStyle(java.time.format.ResolverStyle.STRICT)); return true; } catch (java.time.DateTimeException | IllegalArgumentException invalid) { return false; } }
    /** @name: isBefore <PRE>Strict calendar date before comparison; equality or null false; no clock/timezone.</PRE> @MethodName: isBefore @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isBefore(java.time.LocalDate value, java.time.LocalDate boundary) { return value != null && boundary != null && value.isBefore(boundary); }
    /** @name: isAfter <PRE>Strict calendar date after comparison; equality or null false; no clock/timezone.</PRE> @MethodName: isAfter @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isAfter(java.time.LocalDate value, java.time.LocalDate boundary) { return value != null && boundary != null && value.isAfter(boundary); }
    /** @name: isWithinPeriod <PRE>Inclusive calendar-date period; null or reversed endpoints false; no clock/timezone.</PRE> @MethodName: isWithinPeriod @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isWithinPeriod(java.time.LocalDate value, java.time.LocalDate start, java.time.LocalDate end) { return value != null && start != null && end != null && !start.isAfter(end) && !value.isBefore(start) && !value.isAfter(end); }
    /** @name: convertStringToDate <PRE>Convert nonnull text to LocalDate with strict Locale.ROOT pattern; null text returns null; invalid date/pattern throws, null pattern with text throws NullPointerException.</PRE> @MethodName: convertStringToDate @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static java.time.LocalDate convertStringToDate(String value, String pattern) { if (value == null) return null; return java.time.LocalDate.parse(value, java.time.format.DateTimeFormatter.ofPattern(java.util.Objects.requireNonNull(pattern), java.util.Locale.ROOT).withResolverStyle(java.time.format.ResolverStyle.STRICT)); }
    /** @name: dateToString <PRE>Format LocalDate using Locale.ROOT pattern; null date returns null; invalid pattern throws and null pattern with date throws NullPointerException.</PRE> @MethodName: dateToString @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String dateToString(java.time.LocalDate value, String pattern) { if (value == null) return null; return value.format(java.time.format.DateTimeFormatter.ofPattern(java.util.Objects.requireNonNull(pattern), java.util.Locale.ROOT)); }
}
