package com.yyy.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class User1 {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + "}";
    }
}
