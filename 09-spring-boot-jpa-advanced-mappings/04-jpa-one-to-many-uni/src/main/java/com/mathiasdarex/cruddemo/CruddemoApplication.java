package com.mathiasdarex.cruddemo;

import com.mathiasdarex.cruddemo.dao.AppDAO;
import com.mathiasdarex.cruddemo.entity.Course;
import com.mathiasdarex.cruddemo.entity.Instructor;
import com.mathiasdarex.cruddemo.entity.InstructorDetail;
import com.mathiasdarex.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {

			// createCourseAndReviews(appDAO);

			// retrieveCourseAndReviews(appDAO);

			 deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print course
		System.out.println(tempCourse);

		// print reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("DONE");
	}


	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Downhill - How not to die on the hill - 2");

		// add some reviews
		tempCourse.addReview(new Review("Great Course, I love it!"));
		tempCourse.addReview(new Review("Bad course, I hate it!"));
		tempCourse.addReview(new Review("I can't ride a bike, dunno why I bought it tho"));
		tempCourse.addReview(new Review("I'M BATMAN"));

		// save the course
		System.out.println("Saving course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("DONE!!!");


	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("DONE");

	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("How to update the course title...HAHA ._. ");

		appDAO.update(tempCourse);

		System.out.println("DONE!");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating the instructor id: " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("DONE!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find instructor
		System.out.println("Finding instructor id: " + theId);
		// code will retrieve Instructor AND Courses because we added JOIN FETCH in our query in DAOImpl
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("DONE!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor.getFirstName());

		// find courses for instructor
		System.out.println("Find courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		// assocuate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("DONE!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor.getFirstName());
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("DONE");


	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Chadinson", "gigachad@chadinson.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"https://www.youtube.com/@whocares",
						"Falling");


		// associate objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Sim racing - art of curbs");
		Course tempCourse2 = new Course("Real racing - how not to get beaten up by local 13yo kids");

		// add courses to instructors
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save instructor
		// NOTE: This will ALSO save the courses
		// because CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tenpInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail " + tenpInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: " + tenpInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor thempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + thempInstructor);
		System.out.println("The associated instructorDetail only: ");
	}
	private void createInstructor(AppDAO appDAO) {

//		// create the instructor
//		Instructor tempInstructor =
//				new Instructor("Chad", "Chadinson", "gigachad@chadinson.com");
//
//		// create instructor detail
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail(
//						"https://www.youtube.com/@pinkbike",
//						"Falling");

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Chadinson", "gigachad@chadinson.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"https://www.youtube.com/@pinkbike",
						"Getting up");

		// associate the objects together
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// NOTE: this will ALSO save the details object
		// because of cascadeType.ALL
		System.out.println("Saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}