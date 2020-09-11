package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping(path = "/v1/bank")
@Api(value = "BANK API", tags = "은행", description = " ")
@RestController
public class BankController {
    @ApiOperation(
            value = "연결된 계좌 리스트 조회",
            notes = "notes"
    )
    @GetMapping(value = "/account")
    public ResponseEntity fetchAccounts() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "연결계좌 등록",
            notes = "notes"
    )
    @PostMapping(value = "/account")
    public ResponseEntity addLinkAccount() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "연결계좌 상세조회",
            notes = "notes"
    )
    @GetMapping(value = "/account/{id}")
    public ResponseEntity fetchAccountInfo(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }
}
