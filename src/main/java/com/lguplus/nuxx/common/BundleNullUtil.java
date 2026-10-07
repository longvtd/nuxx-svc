package com.lguplus.nuxx.common;
public final class BundleNullUtil {
    private BundleNullUtil() { }
    public static boolean isNull(Object value) { return value == null; }
    public static boolean isNone(String value) { return value == null || value.isBlank(); }
}
