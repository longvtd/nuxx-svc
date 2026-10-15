package com.lguplus.nuxx.fixture.codeinsight;


/**
 * @name: FixtureConstants
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: FixtureConstants.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
public final class FixtureConstants {
    private FixtureConstants() { }
    /** Synthetic request is awaiting initial handling. */
    public static final String STATUS_REQUESTED = "REQUESTED";
    /** Synthetic refund request requires manual review before any approval. */
    public static final String STATUS_REVIEW_REQUIRED = "REVIEW_REQUIRED";
    /** Synthetic request is awaiting initial handling by code. */
    public static final String REQUESTED_CODE = "Q";
    /** Synthetic refund request requires manual review by code. */
    public static final String REVIEW_CODE = "R";
    public static final String UNDESCRIBED_BASELINE = "U0";
    public static final String UNDESCRIBED_CHANGE = "U1";
    public static final String REVIEW_ALIAS = STATUS_REVIEW_REQUIRED;
}
