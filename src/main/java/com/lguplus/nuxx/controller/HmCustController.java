package com.lguplus.nuxx.controller;

import com.lguplus.nuxx.dto.CustDTO;
import com.lguplus.nuxx.service.HmCustClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "home customer API", description = "홈주문 고객 연계 API")
@RestController
@RequestMapping("/hmcust")
public class HmCustController {

    private final HmCustClientService custClient;

    public HmCustController(HmCustClientService custClient) {
        this.custClient = custClient;
    }

    @Operation(summary = "고객단건조회", description = "고객 도메인에서 고객 정보 조회")
    @GetMapping("/v1/{custId}")
    public CustDTO selectCust(@PathVariable("custId") String custId) {
        return custClient.selectCustInline(custId);
    }

    @Operation(summary = "고객저장", description = "고객 도메인으로 고객 정보 저장")
    @PostMapping("/v1/save")
    public CustDTO saveCust(@RequestBody CustDTO dto) {
        return custClient.saveCust(dto);
    }
}
