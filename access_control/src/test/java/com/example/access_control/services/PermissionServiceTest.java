package com.example.access_control.services;


import com.example.access_control.entity.AdmGroupPermission;
import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.entity.SysMenu;
import com.example.access_control.entity.redis.auth.Permission;
import com.example.access_control.entity.redis.auth.Role;
import com.example.access_control.repository.SysMenu.SysMenuRepository;
import com.example.access_control.repository.admGroupPermission.AdmGroupPermissionRepository;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import com.example.access_control.repository.redis.auth.RoleRedisRepository;
import com.example.access_control.service.auth.PermissionService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    PermissionService ps;

    @Autowired
    private AdmGroupPermissionRepository agpr;

    @Autowired
    private AdmOperGroupRepository aogr;

    @Autowired
    private SysMenuRepository smr;


    @Test
    void addPermissionTest() {
        SysMenu menu = smr.findById(1L).get();
        AdmOperGroup group = aogr.save(AdmOperGroup.builder().groupName("testgroupname").build());
        AdmGroupPermission agp = new AdmGroupPermission();
        agp.setPermission("C,R,U,D");
        agp.setSysMenu(menu);
        agp.setAdmOperGroup(group);

        ps.addPermission(agp);
    }
    @Test
    @Disabled
    void deleteRoleTest() {
    }
}
