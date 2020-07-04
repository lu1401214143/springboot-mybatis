package com.atguigu.dao;

import com.atguigu.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


public interface UserDao {
    public List<User> getAllUsers();

    Integer addUser(User user);
}
