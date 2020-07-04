package com.atguigu.service;

import com.atguigu.bean.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    public List<User> getAllUsers();

    @Transactional
    public Integer addUser(User user);



}
