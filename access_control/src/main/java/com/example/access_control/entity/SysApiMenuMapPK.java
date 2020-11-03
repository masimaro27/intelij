package com.example.access_control.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class SysApiMenuMapPK implements Serializable {

    private Long idxSysMenu;
    private Long idxSysApi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysApiMenuMapPK that = (SysApiMenuMapPK) o;
        return Objects.equals(idxSysMenu, that.idxSysMenu) &&
                Objects.equals(idxSysApi, that.idxSysApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idxSysMenu, idxSysApi);
    }
}
