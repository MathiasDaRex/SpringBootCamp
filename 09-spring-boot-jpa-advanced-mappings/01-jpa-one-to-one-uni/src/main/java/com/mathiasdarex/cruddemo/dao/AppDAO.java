package com.mathiasdarex.cruddemo.dao;

import com.mathiasdarex.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
