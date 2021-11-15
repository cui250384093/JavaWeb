package com.yl.service.impl;

import com.yl.dao.impl.UserDao;
import com.yl.dao.impl.UserDaoImpl;
import com.yl.pojo.User;

/**
 * @author candk
 * @Description
 * @date 10/1/21 - 2:04 PM
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAnsPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        return userDao.queryUserByUserName(username) != null;
    }
}
