package com.example.access_control.repositories.redis;

import com.example.access_control.config.security.CustomUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisGetSetTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test() {
        ValueOperations<String,Object> vop = redisTemplate.opsForValue();
        Collection ta = new ArrayList<>();
        ta.add(new SimpleGrantedAuthority("/test/**:C,R,U,D"));

        CustomUserDetails user = new CustomUserDetails();
        user.setUsername("test");
        user.setPassword("test");
        user.setAuthorities(ta);

        vop.set("test",user);

        CustomUserDetails getUser = (CustomUserDetails) vop.get("test");
        System.out.println(getUser.getUsername());

        user.setUsername("update");
        vop.set("test", user);

        getUser = (CustomUserDetails) vop.get("test");
        System.out.println(getUser.getUsername());

    }
}
