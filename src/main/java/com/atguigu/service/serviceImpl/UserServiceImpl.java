package com.atguigu.service.serviceImpl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>)redisTemplate.opsForList().range("users",0,-1);
        System.out.println(users);
        if (users.size()!=0){
            System.out.println("从Redis中获取");
            return users;
        }
        List<User> userList = userDao.getAllUsers();
       redisTemplate.opsForList().leftPush("users", userList);
        return userList;
    }

    @Override
    public Integer addUser(User user) {
        userDao.addUser(user);
        int i=1/0;
        return null;
    }

}
