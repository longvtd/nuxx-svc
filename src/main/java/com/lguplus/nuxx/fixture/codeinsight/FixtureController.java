package com.lguplus.nuxx.fixture.codeinsight;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: FixtureController
 * <PRE>Synthetic source evidence All data is synthetic; this is an isolated manual fixture.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: FixtureController.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Add opt-in Code Insight manual fixture.</PRE>
 */
@RestController
@Tag(name = "Synthetic Code Insight fixture", description = "Source-only fixture; preparation never invokes these routes")
@RequestMapping("/fixture/code-insight")
public class FixtureController {
    private final FixtureService service;
    /** @name: FixtureController <PRE>Bind isolated synthetic fixture service.</PRE> @MethodName: FixtureController @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public FixtureController(FixtureService service) { this.service = service; }
    /** @name: compare <PRE>Expose independent Common Library/constant cases without writes or outbound calls.</PRE> @MethodName: compare @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    @Operation(summary = "Synthetic comparisons", description = "Manual Code Insight source fixture")
    @GetMapping("/compare")
    public java.util.List<String> compare(FixtureRequest request) { return service.all(request); }
    /** @name: database <PRE>Expose a read-only DB source path; never invoked by the fixture tooling.</PRE> @MethodName: database @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    @Operation(summary = "Synthetic DB read", description = "Do not invoke during preparation")
    @GetMapping("/database")
    public java.util.List<FixtureEntity> database(FixtureRequest request) { return service.databaseRead(request); }
    /** @name: external <PRE>Expose outbound metadata source; never invoked by the fixture tooling.</PRE> @MethodName: external @Part: Synthetic Code Insight fixture @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    @Operation(summary = "Synthetic outbound metadata", description = "Do not invoke during preparation")
    @GetMapping("/external")
    public Object external(FixtureRequest request) { return service.externalDomain(request); }
}
