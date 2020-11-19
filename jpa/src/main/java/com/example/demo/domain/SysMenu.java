package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SYS_MENU")
public class SysMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbIdx;
    private String menuName;
    private String actionCode;
    @Column(insertable = false, updatable = false)
    private Date updateTime;
    @Column(insertable = false, updatable = false)
    private Date createTime;

    @Builder.Default
    @OneToMany(mappedBy = "sysMenu", fetch = FetchType.LAZY)
    private List<AdmGroupPermission> permissions = new ArrayList<>();

}
