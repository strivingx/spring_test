package com.yyy.service;

import com.yyy.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/12 0012.
 * 用户业务层
 * 注意实际开发中肯定就是使用@Service注解了，这里为了学习@ImportSource注解方便-
 * 就像注释掉，采用beans.xml配置的方式将UserService加入到Spring容器中去
 */
@Service
public class UserService {

    public String test() {
        return ("service test");
    }

    @Autowired
    private UserDao userDao;

    public String add(String name) {
        userDao.insert(name);
        return "success";
    }

    @Transactional
    public String testWithTransaction() {
        userDao.insert("有事务不能插入数据库");
        int a = 1 / 0;
        return "success";
    }

    public String testWithoutTransaction() {
        userDao.insert("没有事务能插入数据库");
        int a = 1 / 0;
        return "success";
    }

}
