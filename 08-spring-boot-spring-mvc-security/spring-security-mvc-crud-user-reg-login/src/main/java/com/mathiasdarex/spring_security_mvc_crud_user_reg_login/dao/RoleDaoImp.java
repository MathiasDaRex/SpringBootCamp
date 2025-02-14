package com.mathiasdarex.spring_security_mvc_crud_user_reg_login.dao;

import com.mathiasdarex.spring_security_mvc_crud_user_reg_login.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public class RoleDaoImp implements RoleDao{

    @Autowired
    private EntityManager entityManager;

    public RoleDaoImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public Role findRoleByName(String theRoleName) {

        // retrieve/read from database using name
        TypedQuery<Role> theQuery = entityManager.createQuery("FROM Role WHERE name =:roleName", Role.class);
        theQuery.setParameter("roleName", theRoleName);

        Role theRole = null;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }
}
