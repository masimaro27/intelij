package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(path = "/v1/merchant")
@Api(value = "MERCHANT API", tags = "가맹점", description = " ")
@RestController
public class MerchantController {
    @ApiOperation(
            value = "merchant staff list",
            notes = "notes"
    )
    @GetMapping
    public ResponseEntity fetchMerchantStaffs() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "add merchant",
            notes = "notes"
    )
    @PostMapping
    public ResponseEntity addMerchantStaff() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "branch staff merchant",
            notes = "notes"
    )
    @GetMapping(path = "{id}")
    public ResponseEntity fetchMerchantStaffInfo(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "update merchant staff",
            notes = "notes"
    )
    @PatchMapping(path = "{id}")
    public ResponseEntity updateMerchantStaff(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "delete merchant staff",
            notes = "notes"
    )
    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteMerchantStaff(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }


}