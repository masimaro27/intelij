package com.example.access_control.config.startup;

import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import com.example.access_control.repository.admOperator.AdmOperatorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class AllStrategiesExampleBean implements InitializingBean {

    private ValueOperations<String, Object> vop;
    private AdmOperGroupRepository aogr;

    @Autowired
    public AllStrategiesExampleBean(RedisTemplate redisTemplate) {
        this.vop = redisTemplate.opsForValue();
        log.info("Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }
}
