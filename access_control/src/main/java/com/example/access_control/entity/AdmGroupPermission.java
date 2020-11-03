package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AdmGroupPermissionPK.class)
@Entity
@Table(name = "ADM_GROUP_PERMISSION")
public class AdmGroupPermission {
    @Id
    @Column(name = "IDX_ADM_OPER_GROUP", insertable = false, updatable = false)
    private Long idxAdmOperGroup;
    @Id
    @Column(name = "IDX_ADM_SYS_MENU", insertable = false, updatable = false)
    private Long idxAdmSysMenu;

    @ManyToOne
    @JoinColumn(name = "IDX_ADM_OPER_GROUP")
    private AdmOperGroup admOperGroup;

    @ManyToOne
    @JoinColumn(name = "IDX_ADM_SYS_MENU")
    private SysMenu sysMenu;

    private String permission;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date updateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date createTime;
}
