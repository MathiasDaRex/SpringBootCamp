package com.mathiasdarex.cruddemo;

import com.mathiasdarex.cruddemo.dao.AppDAO;
import com.mathiasdarex.cruddemo.entity.Instructor;
import com.mathiasdarex.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 2;
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
		int theId = 1;
		System.out.println("Deleting instructor id " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Instructor with id " + theId + " deleted");
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
				new Instructor("Chad2", "Chadinson2", "gigachad@chadinson.com");

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