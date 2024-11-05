package com.mathiasdarex.cruddemo;

import com.mathiasdarex.cruddemo.dao.StudentDAO;
import com.mathiasdarex.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);

		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Elek");

		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		//
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Mekk", "Elek", "mekkelek@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. generated id: " + theId);

		// retrive student based on the id: primary key
		System.out.println("Retriving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 new student object ....");
		Student tempStudent1 = new Student("Paul", "Doe", "Paul@doe.hu");
		Student tempStudent2 = new Student("Polgar", "Jeno", "32154@doz.hu");
		Student tempStudent3 = new Student("Bogar", "Lajos", "12345@dox.com");


		// save the student object
		System.out.println("Saving students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of the saved student
		System.out.println("Saved students. generated id's: " + tempStudent1.getId() + " " + tempStudent2.getId() + " " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Paul", "Doe", "Paul@doe.hu");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. generated id: " + tempStudent.getId());

	}

}
