package com.mathiasdarex.springboot.crudDemo.dao;

import com.mathiasdarex.springboot.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// to get the CRUD methods out of the box, we just need to extend the JpaRepository interface,
// and type in our entity type, and primary key type

// to expose the methods on another endpoint, we can use @RepositoryRestResource()
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it, we don't need to write any code for the CRUD operations
}
