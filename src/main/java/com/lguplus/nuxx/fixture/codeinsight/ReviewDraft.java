package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: ReviewDraft
 * <PRE>In-memory synthetic draft; assigning an ID does not store or approve it.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: ReviewDraft.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class ReviewDraft {
    private String id;
    /** @name: getId <PRE>Return the in-memory synthetic draft identifier.</PRE> @MethodName: getId @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public String getId() { return id; }
    /** @name: setId <PRE>Set only the in-memory draft identifier; no persistence.</PRE> @MethodName: setId @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public void setId(String value) { id = value; }
}
