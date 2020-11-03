package com.example.access_control.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class AdmGroupPermissionPK implements Serializable {

    private Long idxAdmOperGroup;
    private Long idxAdmSysMenu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmGroupPermissionPK that = (AdmGroupPermissionPK) o;
        return Objects.equals(idxAdmOperGroup, that.idxAdmOperGroup) &&
                Objects.equals(idxAdmSysMenu, that.idxAdmSysMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idxAdmOperGroup, idxAdmSysMenu);
    }
}
