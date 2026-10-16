package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: NumericUtil
 * <PRE>Representative synthetic utility with explicit contracts; no security source claimed.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: NumericUtil.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class NumericUtil {
    private NumericUtil() { }
    /** @name: isNumber <PRE>Strict ASCII signed integer or decimal text; no exponent, spaces, grouping or currency; null false.</PRE> @MethodName: isNumber @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isNumber(String value) { return value != null && value.matches("[+-]?[0-9]+(?:\\.[0-9]+)?"); }
    /** @name: isInteger <PRE>Strict ASCII signed digits, no range restriction; no decimal/exponent/spaces; null false.</PRE> @MethodName: isInteger @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isInteger(String value) { return value != null && value.matches("[+-]?[0-9]+"); }
    /** @name: isDecimal <PRE>Strict ASCII signed digits with mandatory dot and fraction digits; no exponent or spaces; null false.</PRE> @MethodName: isDecimal @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isDecimal(String value) { return value != null && value.matches("[+-]?[0-9]+\\.[0-9]+"); }
    /** @name: isPositive <PRE>True for strictly greater than zero BigDecimal; zero, negative and null false.</PRE> @MethodName: isPositive @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isPositive(java.math.BigDecimal value) { return value != null && value.signum() > 0; }
    /** @name: isInRange <PRE>Inclusive numeric range; null arguments or reversed bounds false; no rounding.</PRE> @MethodName: isInRange @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean isInRange(java.math.BigDecimal value, java.math.BigDecimal minimum, java.math.BigDecimal maximum) { return value != null && minimum != null && maximum != null && minimum.compareTo(maximum) <= 0 && value.compareTo(minimum) >= 0 && value.compareTo(maximum) <= 0; }
    /** @name: toNumber <PRE>Convert strict isNumber text to BigDecimal; null/invalid throws IllegalArgumentException, no default or rounding.</PRE> @MethodName: toNumber @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static java.math.BigDecimal toNumber(String value) { if (!isNumber(value)) throw new IllegalArgumentException("Invalid numeric text"); return new java.math.BigDecimal(value); }
    /** @name: toInteger <PRE>Convert signed ASCII digits to 32-bit Integer; null/invalid/overflow throws IllegalArgumentException.</PRE> @MethodName: toInteger @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static Integer toInteger(String value) { if (!isInteger(value)) throw new IllegalArgumentException("Invalid integer text"); return Integer.valueOf(value); }
    /** @name: toDecimal <PRE>Convert strict signed integer-or-decimal text to BigDecimal; null/invalid throws; no rounding.</PRE> @MethodName: toDecimal @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static java.math.BigDecimal toDecimal(String value) { if (!isNumber(value)) throw new IllegalArgumentException("Invalid decimal text"); return new java.math.BigDecimal(value); }
    /** @name: toBoolean <PRE>Convert only exact lowercase true/false; null, whitespace, numeric flags and other text throw.</PRE> @MethodName: toBoolean @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static boolean toBoolean(String value) { if ("true".equals(value)) return true; if ("false".equals(value)) return false; throw new IllegalArgumentException("Expected true or false"); }
    /** @name: toInteger <PRE>Return parsed 32-bit Integer or argument 1 on null/invalid/overflow; fallback may be null.</PRE> @MethodName: toInteger @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static Integer toInteger(String value, Integer fallback) { try { return toInteger(value); } catch (IllegalArgumentException invalid) { return fallback; } }
}
