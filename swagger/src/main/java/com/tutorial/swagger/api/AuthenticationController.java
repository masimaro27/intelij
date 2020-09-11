package com.tutorial.swagger.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/auth")
@Api(value = "AUTHENTICATION API", tags = "인증", description = " ")
@RestController
public class AuthenticationController {

    @ApiOperation(
            value = "login",
            notes = "notes"
    )
    @PostMapping(value = "/login")
    public ResponseEntity login() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "logout",
            notes = "notes"
    )
    @PostMapping(value = "/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "아이디 찾기",
            notes = "notes"
    )
    @PostMapping(value = "/findId")
    public ResponseEntity findId() {
        return ResponseEntity.ok().build();
    }

}

