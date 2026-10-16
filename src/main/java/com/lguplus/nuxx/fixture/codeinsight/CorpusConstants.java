package com.lguplus.nuxx.fixture.codeinsight;

/**
 * @name: CorpusConstants
 * <PRE>Synthetic format constants; descriptions are source inputs for the real Collector.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: CorpusConstants.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
public final class CorpusConstants {
    private CorpusConstants() { }
    /** Synthetic refund request dates use a strict proleptic-year calendar date format. */
    public static final String REQUEST_DATE_PATTERN = "uuuu-MM-dd";
    /** Synthetic refund validation rejects requests whose status is missing. */
    public static final String STATUS_REQUIRED = "STATUS_REQUIRED";
}
