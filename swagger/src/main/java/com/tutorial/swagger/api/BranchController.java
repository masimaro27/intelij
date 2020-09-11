package com.tutorial.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/branch")
@Api(value = "BRANCH API", tags = "영업점 관리", description = " ")
@RestController
public class BranchController {

    @ApiOperation(
            value = "branch list",
            notes = "notes"
    )
    @GetMapping
    public ResponseEntity fetchBranchs() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "add branch",
            notes = "notes"
    )
    @PostMapping
    public ResponseEntity addBranch() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "branch Detail",
            notes = "notes"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity fetchBranchInfo(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "update branch",
            notes = "notes"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity updateBranch(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "delete branch",
            notes = "notes"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBranch(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().build();
    }
}
