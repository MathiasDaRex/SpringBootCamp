package com.mathiasdarex.cruddemo.dao;

import com.mathiasdarex.cruddemo.entity.Instructor;
import com.mathiasdarex.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void  deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}
