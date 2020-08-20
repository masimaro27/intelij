package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "EMAIL")
    private String email;
    private String password;
    private String username;


}
