package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestDemo {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserService userService;
    @Test
    public void druidTest() throws SQLException {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void transactionalTest(){
        User user = new User(null, "卢佳琦", "lujiaqi", "123456");
        Integer integer = userService.addUser(user);
        System.out.println(user);
   /*     List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }*/
    }
}
