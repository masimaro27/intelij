package com.cache.demo.example;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"addresses"})
@Component
public class CustomerDataService {

    @Cacheable(key = "#customer.name")
    public String getAddress(final Customer customer) {
        return customer.getAddress();
    }

    @Cacheable
    public String getAddress_1(final Customer customer) {
        return customer.getAddress();
    }

    @CachePut(key = "#customer.name")
    public String getAddress_2(final Customer customer) {
        return customer.getAddress();
    }

    /**
     * 동일 파라미터를 가진 2개의 함수에 key값 지정
     * 방법1 : key generator 사용
     * 방법2 : sqEL 사용 key = method_name:parameter
     */



}
