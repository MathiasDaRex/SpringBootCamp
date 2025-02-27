package com.mathiasdarex.cruddemo.dao;

import com.mathiasdarex.cruddemo.entity.Course;
import com.mathiasdarex.cruddemo.entity.Instructor;
import com.mathiasdarex.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void  deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void  deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
