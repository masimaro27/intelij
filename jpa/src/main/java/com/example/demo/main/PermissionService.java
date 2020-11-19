package com.example.demo.main;

import com.example.demo.domain.AdmGroupPermission;
import com.example.demo.repository.AdmGroupPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
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
