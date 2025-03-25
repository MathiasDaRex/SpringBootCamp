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

    // !!! IF WE MAKE A MODIFICATION TO THE DATABASE WE MUST USE @Transactional

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

        // get the courses
        List<Course> courses = tempInstructor.getCourses();

        // break association of courses for the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

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

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        // With this solution Even with Instructor @OneToMany - FetchType.LAZY
        // the code will still retrieve Instructor AND courses
        // JOIN FETCH is similar to EAGER loading, just without hardcoding it.
        TypedQuery<Instructor> query = entityManager.createQuery(
                                            "SELECT i FROM Instructor i "
                                                    + "JOIN FETCH i.courses "
                                                    + "JOIN FETCH i.instructorDetail "
                                                    + "WHERE i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        // retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(tempCourse);

    }

    // this saves the course and the associated reviews, because CascadeType.ALL
    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        // create query
        // JOIN FETCH to retrieve Course AND Reviews
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c " +
                        "JOIN FETCH c.reviews " +
                        "WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        //execute query
        Course course = query.getSingleResult();

        return course;
    }
}
