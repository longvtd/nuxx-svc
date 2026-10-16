package com.lguplus.nuxx.fixture.codeinsight;

import org.springframework.web.bind.annotation.*;

/**
 * @name: UtilityCorpusController
 * <PRE>Thin source-only sample route; corpus preparation never invokes it.</PRE>
 * @author: Vo Tran Dinh Long
 * @class: UtilityCorpusController.java
 * @Date: 2026. 10. 15.
 * @History <PRE>1. 2026. 10. 15. Representative synthetic utility inputs; not security source.</PRE>
 */
@RestController
@RequestMapping("/fixture/code-insight/utilities")
public class UtilityCorpusController {
    private final UtilityCorpusService service;
    /** @name: UtilityCorpusController <PRE>Inject only the synthetic application service.</PRE> @MethodName: UtilityCorpusController @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    public UtilityCorpusController(UtilityCorpusService service) { this.service = service; }
    /** @name: compare <PRE>Reach synthetic utility callers using supplied path inputs; no database or outbound interaction.</PRE> @MethodName: compare @Part: Synthetic utility corpus @author: Vo Tran Dinh Long @ModifiedDate: 2026. 10. 15. */
    @GetMapping("/{status}/{amountText}/{requestedDate}/{customerCode}")
    public java.util.Map<String, Object> compare(@PathVariable("status") String status, @PathVariable("amountText") String amountText, @PathVariable("requestedDate") String requestedDate, @PathVariable("customerCode") String customerCode) {
        return service.all(status, amountText, requestedDate, customerCode);
    }
}
