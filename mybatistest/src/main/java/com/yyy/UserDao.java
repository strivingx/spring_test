package com.yyy;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Insert("insert into user(name) values(#{name})")
    public int insert(String name);

    @Update("update user set name=#{name} where id=#{id}")
    public int update(@Param("id") int id, @Param("name") String name);

    @Delete("delete from user where id = #{id}")
    public int delete(int id);

    @Select("select * from user where name=#{name}")
    public User getByName(String name);

    @Select("select * from user where id=#{id}")
    public User getById(int id);

    @Select("select * from user")
    public List<User> getList();
}
