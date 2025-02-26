package com.mathiasdarex.cruddemo.dao;

import com.mathiasdarex.cruddemo.entity.Course;
import com.mathiasdarex.cruddemo.entity.Instructor;
import com.mathiasdarex.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define a field for our entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // !!! IF WE MAKE A MODIFICATION TO THE DATABASE WE MUST USER @Transactional

    @Override
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);
        // this will ALSO save the details object, because CascadeType.ALL
    }

    // we ALSO retrieve the instructor details object,
    // because the def @OneToOne behavior is fetch type eager
    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // delete the instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // Create query
        TypedQuery<Course> query = entityManager.createQuery(
                                "FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }
}
