package com.example.aop.service;

import com.example.aop.annotation.LogExecutionTime;
import com.example.aop.vo.Human;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @LogExecutionTime
    public void serve(String test, int test1, Human human) throws InterruptedException {
        Thread.sleep(2000);
    }

    public void async() {

    }
}
