package com.mathiasdarex.springboot.crudDemo.dao;

import com.mathiasdarex.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
