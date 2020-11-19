package com.example.access_control.config.startup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        log.info("first command-line parameter:");
    }
}
