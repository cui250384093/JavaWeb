package com.yl.test;

import com.yl.pojo.User;
import com.yl.service.impl.UserService;
import com.yl.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 10/1/21 - 2:12 PM
 */
class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    void registUser() {
        userService.registUser(new User(null, "user1", "666666", "user1@qq.com"));
        userService.registUser(new User(null, "user2", "666666", "user2@qq.com"));
        userService.registUser(new User(null, "user3", "666666", "user3@qq.com"));
    }

    @Test
    void login() {

        System.out.println(userService.login(new User(null, "user1", "666666", null)));
    }

    @org.junit.Test
    void existsUsername() {

        if (userService.existsUsername("user11")) {
            System.out.println("username exists!");
        } else {
            System.out.println("username doesn't exist!");
        }
    }
}