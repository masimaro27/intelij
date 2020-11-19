package com.example.access_control.service.auth;

import com.example.access_control.entity.AdmGroupPermission;
import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.entity.SysMenu;
import com.example.access_control.entity.redis.auth.Role;
import com.example.access_control.repository.SysMenu.SysMenuRepository;
import com.example.access_control.repository.admGroupPermission.AdmGroupPermissionRepository;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import com.example.access_control.repository.redis.auth.RoleRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private RoleRedisRepository roleRedisRepo;

    @Autowired
    private AdmGroupPermissionRepository agpr;

    public void addPermission(AdmGroupPermission admGroupPermission) {
        agpr.save(admGroupPermission);
    }

    public void deleteRole() {

    }

    public void updateRole() {

    }
}
