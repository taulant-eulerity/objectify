package com.company.user;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class MyEntity {
    @Id Long id;
    String value;

    public MyEntity() {} // Needed for Objectify

    public MyEntity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Include getters and setters as necessary
}