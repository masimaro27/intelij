package com.example.access_control.entity;

import com.example.access_control.config.security.CustomGrantedAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADM_OPERATOR")
public class AdmOperator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbIdx;
    private String managerId;
    private String password;

    @Builder.Default
    @OneToMany(mappedBy = "admOperator", fetch = FetchType.LAZY)
    private List<AdmOperGroupUser> groups = new ArrayList<>();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        groups.stream()
                .flatMap((group) -> group.getAdmOperGroup().getPermissions().stream())
                .forEach(p -> {
                    for (SysApiMenuMap  menuApi: p.getSysMenu().getApi()) {
                        auth.add(new CustomGrantedAuthority(menuApi.getSysApi().getApiUrl(), p.getPermission()));
                    }
                });
        return auth;
    }
}
