package com.lguplus.nuxx.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.nuxx.dto.RefundReqDTO;
import com.lguplus.nuxx.entity.RefundEntity;
import com.lguplus.nuxx.service.RefundService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @name: 환불컨트롤러
 * <PRE>환불 생성 REST 요청을 환불 서비스로 전달합니다.</PRE>
 * @class: RefundController.java
 * @Date: 2026. 10. 06.
 */
@RestController
@Tag(name = "refund API", description = "환불 API")
@RequestMapping("/refund")
public class RefundController {
    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    /**
     * @name: 환불생성요청
     * <PRE>결제 식별자, 고객 식별자, 환불 금액으로 환불을 생성합니다.</PRE>
     * @MethodName: createRefund
     * @Part: 차세대 아키텍처
     */
    @Operation(summary = "환불생성", description = "고객 결제에 대한 환불을 생성합니다.")
    @PostMapping("/create-refund")
    public RefundEntity createRefund(@ParameterObject RefundReqDTO request) {
        return refundService.createRefund(request);
    }
}
