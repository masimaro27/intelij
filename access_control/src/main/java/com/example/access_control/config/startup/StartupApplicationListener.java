package com.example.access_control.config.startup;

import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.entity.redis.auth.Permission;
import com.example.access_control.entity.redis.auth.Role;
import com.example.access_control.repository.redis.auth.RoleRedisRepository;
import com.example.access_control.service.AdmOperGroup.AdmOperGroupService;
import com.example.access_control.utils.ApplicationContextProvider;
import com.example.access_control.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContextStartedEvenet");
        RedisTemplate template = (RedisTemplate) BeanUtils.getBean("redisTemplate");
        AdmOperGroupService aogs = (AdmOperGroupService) BeanUtils.getBean("admOperGroupService");
        List<AdmOperGroup> groups = aogs.getAllAdmOperGroups();
        RoleRedisRepository roleRedisRepo = (RoleRedisRepository) BeanUtils.getBean("roleRedisRepository");

        /**
         * cache format:

      * key : groupname
         * value : [{ url: "/test/**", actions: "C,R,U,D" }]
         */
        for (AdmOperGroup group: groups) {
            Role role = Role.generate(group);
            roleRedisRepo.save(role);
        }
    }
}
