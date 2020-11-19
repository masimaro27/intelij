package com.example.demo.repository;

import com.example.demo.domain.AdmGroupPermission;
import com.example.demo.domain.AdmGroupPermissionPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface AdmGroupPermissionRepository extends JpaRepository<AdmGroupPermission, AdmGroupPermissionPK> {


}
