package com.yl.service.impl;

import com.yl.pojo.User;

/**
 * @author candk
 * @Description
 * @date 10/1/21 - 2:01 PM
 */
public interface UserService {

    /**
     * @param user
     */
    public void registUser(User user);

    /**
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
