package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addr;
    private String subAddr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_IDX")
    private Account account;

    public void setAccount(Account account) {
        if (this.account != null) {
            this.account.getAddrs().remove(this);
        }
        this.account = account;
        account.getAddrs().add(this);
    }
}
