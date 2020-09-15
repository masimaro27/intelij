package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMAIL")
    private String email;
    private String password;
    private String username;

    @OneToMany(mappedBy = "id")
    private List<Address> addrs = new ArrayList<>();
    public void addAddrs(Address addr) {
        this.addrs.add(addr);
        addr.setAccount(this);
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s", this.id, this.email, this.password, this.username);
    }
}
