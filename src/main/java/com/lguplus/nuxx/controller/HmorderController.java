package com.lguplus.nuxx.controller;

import com.lguplus.nuxx.dto.PhoneDTO;
import com.lguplus.nuxx.dto.PhoneReqDTO;
import com.lguplus.nuxx.service.HmOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: Home order controller
 * <PRE>
 * management home order API
 * </PRE>
 * @author: Tester (tester@example.local)
 * @class  : HmorderController.java
 * @Date   : 2026. 10. 01.
 * @History
 * <PRE>
 * No    Date              time             Author              Desc
 *----   ----------------- ---------------- -----------------   ----------
 *     1.  2026. 10. 01.   09:00:00.        Tester.             Initial creation
 * </PRE>
 */
@Tag(name = "home order API", description = "홈주문 휴대폰 주문 관리 API")
@RestController
@RequestMapping("/hmorder")
public class HmorderController {

    private final HmOrderService serviceHm;

    public HmorderController(HmOrderService serviceHm) {
        this.serviceHm = serviceHm;
    }

    @Operation(summary = "휴대폰주문목록조회", method = "GET", description = "휴대폰 주문 목록 조회")
    @GetMapping("/phone/v1/list")
    public List<PhoneDTO> retrievePhone(@ParameterObject PhoneReqDTO dtoObj) {
        return this.serviceHm.retrievePhone(dtoObj);
    }

    @Operation(summary = "휴대폰주문단건조회", description = "휴대폰 주문 ID로 단건 조회")
    @GetMapping("/phone/v1/{phoneId}")
    public List<PhoneDTO> retrievePhoneById(@PathVariable("phoneId") String phoneId) {
        return this.serviceHm.retrievePhone(phoneId);
    }

    @Operation(summary = "휴대폰주문저장", description = "휴대폰 주문 저장")
    @PostMapping("/phone/v1/save")
    public void savePhone(@ParameterObject PhoneReqDTO dtoObj) {
        serviceHm.savePhone(dtoObj);
    }

    @PostMapping("/phone/v1/change")
    public String changePhone(@ParameterObject PhoneReqDTO dtoObj) {
        return serviceHm.changePhone(serviceHm.retrievePhone(dtoObj));
    }
}
