package com.mathiasdarex.springboot.thymeleafdemo.dao;

import com.mathiasdarex.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code!

    // add a method to sort by last name
    // Spring Data JPA magic - makes the query by the name of the method behind the scenes
    // here it's "FROM Employee ORDER BY lastName ASC"
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    public List<Employee> findAllByOrderByLastNameAsc();

}
