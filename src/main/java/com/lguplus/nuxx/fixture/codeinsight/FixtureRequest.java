package com.lguplus.nuxx.fixture.codeinsight;


/**
 * @name: FixtureRequest
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: FixtureRequest.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
public final class FixtureRequest {
    private final String status;
    private final String previousStatus;
    /** @name: FixtureRequest <PRE>Create immutable synthetic inputs.</PRE> @MethodName: FixtureRequest @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public FixtureRequest(String status, String previousStatus) { this.status = status; this.previousStatus = previousStatus; }
    /** @name: getStatus <PRE>Read the supplied synthetic status.</PRE> @MethodName: getStatus @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public String getStatus() { return status; }
    /** @name: getPreviousStatus <PRE>Read the comparison input for baseline guard cases.</PRE> @MethodName: getPreviousStatus @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public String getPreviousStatus() { return previousStatus; }
}
