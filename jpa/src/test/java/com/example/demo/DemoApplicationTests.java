package com.example.demo;

import com.example.demo.domain.Account;
import com.example.demo.domain.Address;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

    @Autowired
    DemoService demoService;

    @Test
    void contextLoads() {
    }

    @Test
    void selectAddressTest() {
        Address address = demoService.findAddressById(1);
        Assertions.assertEquals(address.getId(), 1);
    }

    @Test
    void selectTest() {
        Account account = demoService.findById(1);
        Assertions.assertEquals(account.getId(), 1);
    }

}
