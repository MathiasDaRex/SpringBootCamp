package com.mathiasdarex.springboot.crudDemo.service;

import com.mathiasdarex.springboot.crudDemo.dao.EmployeeDAO;
import com.mathiasdarex.springboot.crudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // define field for employeeDAO
    private EmployeeDAO employeeDAO;

    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeDAO){
        employeeDAO = theEmployeDAO;
    }

    // Here we just delegate the calls to the DAO <- EASY PEASY

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    // we update the database so we have to use the @Transactional annotation right here at the service layer
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
