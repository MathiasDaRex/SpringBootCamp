package com.mathiasdarex.springboot.crudDemo.service;

import com.mathiasdarex.springboot.crudDemo.dao.EmployeeRepository;
import com.mathiasdarex.springboot.crudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // define field for employeeRepository
    private EmployeeRepository employeeRepository;

    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    // Here we just delegate the calls to the repository
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // JPA repository makes use of Optional-s, here is how to use them
    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    // we update the database so we have to use the @Transactional annotation right here at the service layer
    // @Transactional  <- JPA repository has this out of the box, so we don't need it anymore
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    // @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
