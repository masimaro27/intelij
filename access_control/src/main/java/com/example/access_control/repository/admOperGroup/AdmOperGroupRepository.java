package com.example.access_control.repository.admOperGroup;

import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.entity.AdmOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdmOperGroupRepository extends JpaRepository<AdmOperGroup, Long>, AdmOperGroupCustomRepository {

}
