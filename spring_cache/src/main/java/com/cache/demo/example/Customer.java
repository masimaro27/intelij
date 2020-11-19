package com.cache.demo.example;

import java.io.Serializable;

public class Customer implements Serializable {

    private String id;
    private String name;
    private String address;

    public Customer() {
        super();
    }

    public Customer(final String name, final String address) {
        this.name = name;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setCustomerAddress(final String address) {
        this.address = name + "," + address;
    }
}
