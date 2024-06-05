package com.company.user;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class User {
    @Id Long id;  // This is necessary for Objectify

    @Index private List<String> list;
    @Index private List<String> initList = new ArrayList<>();
    @Index private Set<String> set; ;
    @Index private Set<String> initSet = new HashSet<>();


    // Default constructor
    public User() {
        this.initList = new ArrayList<>();
        this.initSet = new HashSet<>();
    }


    public User(List<String> initList, Set<String> initSet) {
        this.initList = initList;
        this.initSet = initSet;
    }


    public User(List<String> list, List<String> initList, Set<String> set, Set<String> initSet) {
        this.list = list;
        this.initList = initList;
        this.set = set;
        this.initSet = initSet;
    }

    public long getId() {
        return this.id;
    }
    public List<String> getList() {
        return list;
    }

    public List<String> getInitList() {
        return initList;
    }

    public Set<String> getSet() {
        return set;
    }

    public Set<String> getInitSet() {
        return initSet;
    }
}
