package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: SampleBusinessException
 * <PRE>Representative synthetic utility with explicit contracts; no security source claimed.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: SampleBusinessException.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class SampleBusinessException extends RuntimeException {
    /** @name: <init> <PRE>Construct a RuntimeException carrying the supplied nonnull code as message; no persistence or approval.</PRE> @MethodName: <init> @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public SampleBusinessException(String code) { super(java.util.Objects.requireNonNull(code, "code")); }
}
