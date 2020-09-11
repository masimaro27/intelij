package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/branch/staff")
@Api(value = "BRANCH STAFF API", tags = "영업직원 관리", description = " ")
@RestController
public class BranchStaffController {
    @ApiOperation(
            value = "branch staff list",
            notes = "notes"
    )
    @GetMapping
    public ResponseEntity fetchBranchStaffs() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "add branch",
            notes = "notes"
    )
    @PostMapping
    public ResponseEntity addBranchStaff() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "branch staff Detail",
            notes = "notes"
    )
    @GetMapping(path = "{id}")
    public ResponseEntity fetchBranchStaffInfo(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "update branch staff",
            notes = "notes"
    )
    @PatchMapping(path = "{id}")
    public ResponseEntity updateBranchStaff(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "delete branch staff",
            notes = "notes"
    )
    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteBranchStaff(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }



}
