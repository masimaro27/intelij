package com.example.access_control.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "admOperGroup", fetch = FetchType.LAZY)
    private List<AdmGroupPermission> permissions = new ArrayList<>();

}
