package com.wang.springboot.redis.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String id;

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }

    public Person() {}
}
