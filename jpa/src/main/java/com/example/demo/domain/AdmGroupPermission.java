package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AdmGroupPermissionPK.class)
@Entity
@Table(name = "ADM_GROUP_PERMISSION")
public class AdmGroupPermission {

    @Id
    @ManyToOne
    @JoinColumn(name = "IDX_ADM_OPER_GROUP")
    private AdmOperGroup admOperGroup;
    @Id
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

    public void setAdmOperGroup(AdmOperGroup group) {
        System.out.println("setAdmOperGroup");
        this.admOperGroup = group;
        if (!group.getPermissions().contains(this)) {
            group.getPermissions().add(this);
        }
    }
}
