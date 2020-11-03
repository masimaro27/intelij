package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SysApiMenuMapPK.class)
@Entity
@Table(name = "SYS_API_MENU_MAP")
public class SysApiMenuMap {

    @Id
    @Column(name = "IDX_SYS_MENU", insertable = false, updatable = false)
    private Long idxSysMenu;
    @Id
    @Column(name = "IDX_SYS_API", insertable = false, updatable = false)
    private Long idxSysApi;

    @ManyToOne
    @JoinColumn(name = "IDX_SYS_MENU")
    private SysMenu sysMenu;

    @ManyToOne
    @JoinColumn(name = "IDX_SYS_API")
    private SysApi sysApi;


}
