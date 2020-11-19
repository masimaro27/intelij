package com.example.access_control.entity;

import com.example.access_control.config.security.CustomGrantedAuthority;
import com.example.access_control.entity.redis.auth.Permission;
import com.example.access_control.entity.redis.auth.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADM_OPER_GROUP")
public class AdmOperGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbIdx;
    private String groupName;

    @Builder.Default
    @OneToMany(mappedBy = "admOperGroup", fetch = FetchType.LAZY)
    private List<AdmOperGroupUser> users = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "admOperGroup", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AdmGroupPermission> permissions = new ArrayList<>();

    @Override
    public String toString() {
//        List<Long> userIdxs =  users.size() > 0 ? users.stream().map(u -> u.getIdxAdmOperator()).collect(Collectors.toList()) : null;
//        List<Long> menuIdxs = permissions.size() > 0 ? permissions.stream().map(p -> p.getIdxAdmSysMenu()).collect(Collectors.toList()) : null;
        return "AdmOperGroup{" +
                "dbIdx=" + dbIdx +
                ", groupName='" + groupName + '\'' +
//                ", user idxs=" + userIdxs +
//                ", permission menu idxs=" + menuIdxs +
                '}';
    }

    public void addPermission(AdmGroupPermission permission) {
        this.permissions.add(permission);
        if (permission.getAdmOperGroup() != this) {
            permission.setAdmOperGroup(this);
        }
    }
}
