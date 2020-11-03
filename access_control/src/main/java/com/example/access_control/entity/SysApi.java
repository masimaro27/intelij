package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SYS_API")
public class SysApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbIdx;
    private String apiVer;
    private String actionCode;
    private String apiUrl;

    @Column(insertable = false, updatable = false)
    private Date updateTime;
    @Column(insertable = false, updatable = false)
    private Date createTime;

    @Builder.Default
    @OneToMany(mappedBy = "sysMenu", fetch = FetchType.LAZY)
    private List<SysApiMenuMap> menus = new ArrayList<>();
}
