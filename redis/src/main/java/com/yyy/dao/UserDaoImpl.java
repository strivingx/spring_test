package com.yyy.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

   /* @Cacheable(key = "#user.getId()")
    @Override
    public void insert(User user) {
        System.out.println("insert user");
    }

    @CachePut(key = "#user.getId()")
    @Override
    public void update(User user) {
        System.out.println("update user");
    }

    @CacheEvict(key = "#id")
    @Override
    public void deleteById(int id) {
        System.out.println("delete user");

    }

    @Override
    public User getById(int id) {
        System.out.println("get user");
        User user = new User();
        user.setId(id);
        user.setName("yyy");
        return user;
    }*/

}
