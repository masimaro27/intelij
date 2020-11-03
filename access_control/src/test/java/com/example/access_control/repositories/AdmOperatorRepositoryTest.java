package com.example.access_control.repositories;

import com.example.access_control.entity.AdmOperator;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import com.example.access_control.repository.admOperator.AdmOperatorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class AdmOperatorRepositoryTest {

    @Autowired
    AdmOperatorRepository ao;

    @Test
    void hello() {
        for (AdmOperator ao : ao.findAll()) {
            System.out.println(ao.getDbIdx());
        }
        Assertions.assertTrue(ao.findAll() != null);
    }


}
