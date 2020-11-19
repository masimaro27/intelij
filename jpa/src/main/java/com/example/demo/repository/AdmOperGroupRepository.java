package com.example.demo.repository;

import com.example.demo.domain.AdmOperGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmOperGroupRepository extends JpaRepository<AdmOperGroup, Long> {

}
