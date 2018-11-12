package com.yyy.domain;

/**
 * User实体映射类
 * Created by Administrator on 2017/11/24.
 */

public class User {

    private int id;
    private String name;
    private boolean sex;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + "}";
    }
}
