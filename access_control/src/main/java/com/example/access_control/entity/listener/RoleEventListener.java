package com.example.access_control.entity.listener;

import com.example.access_control.entity.AdmGroupPermission;
import com.example.access_control.entity.redis.auth.Role;
import com.example.access_control.repository.redis.auth.RoleRedisRepository;
import com.example.access_control.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Iterator;

@Slf4j
public class RoleEventListener {
    private Role getRoleCache(Long groupIdx) {
        RoleRedisRepository roleRedisRepo = (RoleRedisRepository) BeanUtils.getBean("roleRedisRepository");
        return roleRedisRepo.findById(groupIdx).orElse(new Role());
    }

    @PostLoad
    public void postLoad(AdmGroupPermission agp) {

    }

    @PostPersist
    public void postPersist(AdmGroupPermission agp) {
        Role.add(agp);
    }

    @PostUpdate
    public void postUpdate(AdmGroupPermission agp) {
        log.info("post update: {}", agp);
        Role.update(agp);

    }

    @PostRemove
    public void postRemove(AdmGroupPermission agp) {
        log.info("post remove: {}", agp);
        Role.delete(agp);
    }
}
