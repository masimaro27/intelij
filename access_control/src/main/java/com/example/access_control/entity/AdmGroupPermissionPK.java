package com.example.access_control.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdmGroupPermissionPK implements Serializable {

    private Long admOperGroup;
    private Long sysMenu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmGroupPermissionPK that = (AdmGroupPermissionPK) o;
        return Objects.equals(admOperGroup, that.admOperGroup) &&
                Objects.equals(sysMenu, that.sysMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admOperGroup, sysMenu);
    }
}
