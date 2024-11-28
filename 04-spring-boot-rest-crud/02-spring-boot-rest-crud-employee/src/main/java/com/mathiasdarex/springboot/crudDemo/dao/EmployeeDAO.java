package com.mathiasdarex.springboot.crudDemo.dao;

import com.mathiasdarex.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
