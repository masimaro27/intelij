package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/settlement")
@Api(value = "SETTLEMENT API", tags = "정산", description = " ")
@RestController
public class SettlementController {
    @ApiOperation(
            value = "settlement statistic",
            notes = "notes"
    )
    @GetMapping(value = "/statistic")
    public ResponseEntity fetchSettlementStatistic() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "merchant settlement",
            notes = "notes"
    )
    @GetMapping(value = "/merchant")
    public ResponseEntity fetchMerchantSettlement() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "branch settlement list",
            notes = "notes"
    )
    @GetMapping(value = "/branch")
    public ResponseEntity fetchBranchSettlement() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "detail branch settlement ",
            notes = "notes"
    )
    @GetMapping(value = "/branch/{id}")
    public ResponseEntity fetchBranchSettlementInfo(@PathVariable(name = "id") int bid) {
        return ResponseEntity.ok().build();
    }
}