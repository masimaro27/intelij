package com.example.access_control.entity.redis.auth;

import com.example.access_control.entity.AdmGroupPermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@Data
public class Permission implements Serializable {
    private Long menuIdx;
    private String url;
    private String actions;

    public static Permission generate(AdmGroupPermission agp) {
        String url = agp.getSysMenu().getApi().get(0).getSysApi().getApiUrl();
        return new Permission(agp.getSysMenu().getDbIdx(), url, agp.getPermission());
    }

    public Permission update(AdmGroupPermission agp) {
        this.setActions(agp.getPermission());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(menuIdx, that.menuIdx) &&
                Objects.equals(url, that.url) &&
                Objects.equals(actions, that.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuIdx, url, actions);
    }
}
