package com.yyy.mapper;

import com.yyy.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByPhone(@Param("name") String name);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(@Param("id") int id);

    @Insert("INSERT INTO user(NAME) VALUES(#{name})")
    int insert(@Param("name") String name);

}

