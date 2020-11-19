package com.example.access_control.service.AdmOperGroup;

import com.example.access_control.entity.AdmOperGroup;
import com.example.access_control.repository.admOperGroup.AdmOperGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "admOperGroupService")
@RequiredArgsConstructor
public class AdmOperGroupService {

    private final AdmOperGroupRepository aogr;

    public List<AdmOperGroup> getAllAdmOperGroups() {
        return aogr.findAll();
    }
}
