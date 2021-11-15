package com.yl.dao.impl;

import com.yl.pojo.User;

/**
 * @author candk
 * @Description
 * @date 10/1/21 - 10:56 AM
 */
public interface UserDao {




    /**
     * @param userName
     * @return
     */
    public User queryUserByUserName(String userName);


    /**
     * @param userName
     * @param password
     * @return
     */
    public User queryUserByUserNameAnsPassword(String userName, String password);


    /**
     * save user info
     * @param user
     * @return
     */
    public int saveUser(User user);

}
