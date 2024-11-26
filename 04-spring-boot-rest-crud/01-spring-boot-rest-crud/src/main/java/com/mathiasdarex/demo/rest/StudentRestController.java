package com.mathiasdarex.demo.rest;

import com.mathiasdarex.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Kovács", "Laci"));
        theStudents.add(new Student("Super", "Mario"));
        theStudents.add(new Student("Steven", "Smith"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return one student at the index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Just index into the list ... keep it simple for now

        // check the studentId again list size

        if ( (studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);

    }
}
