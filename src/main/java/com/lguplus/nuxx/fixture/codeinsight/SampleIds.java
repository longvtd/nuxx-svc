package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: SampleIds
 * <PRE>Representative synthetic utility with explicit contracts; no security source claimed.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: SampleIds.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class SampleIds {
    private SampleIds() { }
    /** @name: nextId <PRE>Generate a random UUID string; no sequence, persistence or guaranteed collision-free global identity.</PRE> @MethodName: nextId @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public static String nextId() { return java.util.UUID.randomUUID().toString(); }
}
