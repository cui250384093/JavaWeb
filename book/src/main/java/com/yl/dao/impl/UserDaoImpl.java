package com.yl.dao.impl;

import com.yl.pojo.User;

/**
 * @author candk
 * @Description
 * @date 10/1/21 - 11:10 AM
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUserName(String userName) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return (User) queryForOne(User.class, sql, userName);
    }

    @Override
    public User queryUserByUserNameAnsPassword(String userName, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";

        return (User) queryForOne(User.class, sql, userName, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
