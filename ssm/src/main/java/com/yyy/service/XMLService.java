package com.yyy.service;

/**
 * Created by Administrator on 2018/7/12 0012.
 * 用户业务层
 * 注意实际开发中肯定就是使用@Service注解了，这里为了学习@ImportSource注解方便-
 * 就像注释掉，采用beans.xml配置的方式将UserService加入到Spring容器中去
 */
// @Service
public class XMLService {

    public String test() {
        return ("service test");
    }
}
