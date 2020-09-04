package com.tutorial.swagger.api;

import com.tutorial.swagger.domain.Account;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/v1/api")
@Api(value = "TutorialController", tags = "description", description = "한글")
@RestController
public class TutorialController {

    @ApiOperation(value = "read", notes = "example")
    @ApiResponses({
            @ApiResponse(code=200,message="ok"),
            @ApiResponse(code=500,message="server error")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity read(
            @ApiParam(value = "id", required = true, example = "1")@PathVariable String id) {
        return ResponseEntity.ok().build();

    }

    @ApiOperation(
            value = "add request",
            response = com.tutorial.swagger.domain.Example.class,
            produces = "application/json", // response content type
            consumes = "application/json", // ?
            protocols = "http"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @ApiImplicitParam(
            name = "account",
            dataType="Account",
            value = "{'snapshot' : {'type' : 'AAA'}}",
            examples = @io.swagger.annotations.Example(
                    value = {
                            @ExampleProperty(value = "{'snapshot'：{'type': 'AAA'}}", mediaType = "application/json")
                    }
            ))
    @PostMapping(value = "/add")
    public ResponseEntity add(@ApiParam(value = "account object that needs to be added data", required = true )@RequestBody @Valid Account account) {
        return ResponseEntity.ok().build();
    }

}
