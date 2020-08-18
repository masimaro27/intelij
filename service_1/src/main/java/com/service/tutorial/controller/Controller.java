package com.service.tutorial.controller;

import com.service.tutorial.vo.Foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Controller {

    private long id;
    private HttpServletRequest req;
    private HttpServletResponse res;

    @GetMapping("/foos/{id}")
    public Foo findById(
            @PathVariable long id, HttpServletRequest req, HttpServletResponse res) {
        return new Foo(1L, "name");
    }

}
