package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/v1/sales")
@Api(value = "SALES API", tags = "매출", description = " ")
@RestController
public class SalesController {
    @ApiOperation(
            value = "매출 통계",
            notes = "notes"
    )
    @GetMapping(value = "/sales")
    public ResponseEntity fetchSalesStatistic() {
        return ResponseEntity.ok().build();
    }
    @ApiOperation(
            value = "가맹점 매출 상세조회",
            notes = "notes"
    )
    @GetMapping(value = "/sales/merchant")
    public ResponseEntity fetchMerchantSalesInfo() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "영업점 매출 목록조회",
            notes = "notes"
    )
    @GetMapping(value = "/sales/branch")
    public ResponseEntity fetchBranchSales() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "영업점 매출 상세조회",
            notes = "notes"
    )
    @GetMapping(value = "/sales/branch/{id}")
    public ResponseEntity fetchBranchSalesInfo() {
        return ResponseEntity.ok().build();
    }
}
