package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/12 0012.
 * 用户类--实体
 * 采用@Value 注入初始值
 */
@Component
public class User implements Serializable {
    @Value("9527")
    private Integer id;
    @Value("张三")
    private String userName;
    @Value("18")
    private String age;
    @Value("1993/08/15")
    private Date birthday;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

