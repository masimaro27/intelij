package com.tutorial.swagger.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/v1/noti")
@Api(value = "공지사항 API", tags = "공지사항", description = " ")
@RestController
public class NotiController {

    @ApiOperation(value = "notice list", notes = "what?")
    @GetMapping
    public ResponseEntity fetchNotices() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "detail",
            notes = "what?",
            produces = "application/json",
            protocols = "https"
    )
    @GetMapping(path = "{id}")
    public ResponseEntity fetchNoticeInfo(@ApiParam(value = "id", required = true, example = "1")@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}
