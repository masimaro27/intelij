package com.cache.demo.caching;

import com.cache.demo.config.RedisCacheConfig;
import com.cache.demo.config.RedisConfig;
import com.cache.demo.example.Customer;
import com.cache.demo.example.CustomerDataService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        CustomerDataService.class,
        RedisConfig.class,
        RedisCacheConfig.class
})
public class RedisCachingTest {

    @Autowired
    private CustomerDataService service;

    @Test
    public void whenGettingAddress_thenCorrect() {
        Customer cust = new Customer("Tom", "67-2, Downing Street, NY");
        service.getAddress(cust);
        service.getAddress(cust);

        cust = new Customer("Tom", "67-2, Downing Street, Micigan");
        service.getAddress_2(cust);
        service.getAddress_2(cust);

        cust = new Customer("Tom", "67-2, Downing Street, SF");
        service.getAddress_1(cust);
        service.getAddress_1(cust);

    }
}
