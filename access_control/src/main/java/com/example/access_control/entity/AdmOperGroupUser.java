package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AdmOperGroupUserPK.class)
@Entity
@Table(name = "ADM_OPER_GROUP_USER")
public class AdmOperGroupUser {

    @Id
    @Column(name = "IDX_ADM_OPERATOR", insertable = false, updatable = false)
    private Long idxAdmOperator;
    @Id
    @Column(name = "IDX_ADM_OPER_GROUP", insertable = false, updatable = false)
    private Long idxAdmOperGroup;

    @ManyToOne
    @JoinColumn(name = "IDX_ADM_OPERATOR")
    private AdmOperator admOperator;

    @ManyToOne
    @JoinColumn(name = "IDX_ADM_OPER_GROUP")
    private AdmOperGroup admOperGroup;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date createTime;
}
