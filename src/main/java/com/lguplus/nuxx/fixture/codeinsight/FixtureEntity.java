package com.lguplus.nuxx.fixture.codeinsight;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @name: FixtureEntity
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: FixtureEntity.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
@Entity
@Table(name = "TB_CI_FIXTURE_REVIEW")
public class FixtureEntity {
    /** Synthetic status code for manual fixture review; not production data. */
    @Id
    @Column(name = "STATUS_CODE")
    private String status;
    /** @name: getStatus <PRE>Read synthetic status schema context.</PRE> @MethodName: getStatus @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public String getStatus() { return status; }
}
