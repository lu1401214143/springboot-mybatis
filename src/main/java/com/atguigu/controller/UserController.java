package com.atguigu.controller;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/listuser")
    public List<User> ListUser(){
        return userService.getAllUsers();
    }

    @RequestMapping("/addUser")
    public String  addUser(){
        User user = new User(null, "卢佳琦", "lujiaqi", "123456");
        Integer integer = userService.addUser(user);
        System.out.println(user);
        return "ok";
    }

}
