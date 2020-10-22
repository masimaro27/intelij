package com.example.aop.vo;


import lombok.Data;

@Data
public class Child {
    private String name;
    private int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
