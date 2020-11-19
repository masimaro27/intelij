package com.example.access_control.repository.SysMenu;

import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long>, SysMenuCustomRepository {

}
