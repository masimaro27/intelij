package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Data
@NoArgsConstructor
public class AdmOperGroupUserPK implements Serializable {
    private Long idxAdmOperGroup;
    private Long idxAdmOperator;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AdmOperGroupUserPK))
            return false;
        AdmOperGroupUserPK aogu = (AdmOperGroupUserPK)o;
        return Objects.equals(idxAdmOperGroup, aogu.idxAdmOperGroup) &&
                Objects.equals(idxAdmOperator, aogu.idxAdmOperator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idxAdmOperGroup, idxAdmOperator);
    }
}
