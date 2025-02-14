package com.mathiasdarex.spring_security_mvc_crud_user_reg_login.dao;

import com.mathiasdarex.spring_security_mvc_crud_user_reg_login.entity.User;

public interface UserDao {

    public User findUserByName(String userName);

    void save(User theUser);
}
