package com.yyy.service;

import com.yyy.domain.User;
import com.yyy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(int id) {
        return userMapper.getById(id);
    }
}
