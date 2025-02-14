package com.mathiasdarex.spring_security_mvc_crud_user_reg_login.dao;

import com.mathiasdarex.spring_security_mvc_crud_user_reg_login.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;

@Repository
public class UserDaoImp implements UserDao{

    private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public User findUserByName(String theUserName) {

        // retrieve/read from database using username
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User WHERE userName=:uName AND enabled=true", User.class);
        theQuery.setParameter("uName", theUserName);

        User theUser = null;
        try{
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public void save(User theUser) {

    }
}
