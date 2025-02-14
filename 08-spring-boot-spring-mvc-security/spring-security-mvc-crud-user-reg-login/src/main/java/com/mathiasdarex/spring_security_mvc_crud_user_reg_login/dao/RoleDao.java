package com.mathiasdarex.spring_security_mvc_crud_user_reg_login.dao;

import com.mathiasdarex.spring_security_mvc_crud_user_reg_login.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);
}
