package com.example.access_control.repository.admGroupPermission;

import com.example.access_control.entity.AdmGroupPermission;
import com.example.access_control.entity.AdmGroupPermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmGroupPermissionRepository extends JpaRepository<AdmGroupPermission, AdmGroupPermissionPK>, AdmGroupPermissionCustomRepository {


}
