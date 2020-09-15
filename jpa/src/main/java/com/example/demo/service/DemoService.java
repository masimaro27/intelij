package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Address;
import com.example.demo.domain.Hobby;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.DemoRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DemoService {

    @Autowired
    public DemoRepository demoRepository;

    @Autowired
    public AddressRepository addressRepository;

    @Transactional
    public Account findById(long id) {
        Account account = demoRepository.findById(id).get();
        System.out.println(account.getAddrs().get(0).getAddr());

        return account;

    }

    @Transactional
    public Address findAddressById(long id) {
        val address = addressRepository.findById(1L).get();
        System.out.println(address.getAddr());
        System.out.println(address.getAccount().getEmail());
        return address;
    }

}
