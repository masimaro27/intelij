package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/payment")
@Api(value = "PAYMENT API", tags = "결제", description = " ")
@RestController
public class PaymentController {
    @ApiOperation(
            value = "결제내역 목록조회",
            notes = "notes"
    )
    @GetMapping
    public ResponseEntity fetchPayments() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "결제내역 상세조회",
            notes = "notes"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity fetchPaymentInfo(@PathVariable(name = "id") String pId) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "매장용 QR 검증",
            notes = "notes"
    )
    @GetMapping(value = "/verify/merchant/qr")
    public ResponseEntity verifyMerchantQR() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "결제요청",
            notes = "notes"
    )
    @PostMapping(value = "/request")
    public ResponseEntity procPayment() {
        return ResponseEntity.ok().build();
    }
}