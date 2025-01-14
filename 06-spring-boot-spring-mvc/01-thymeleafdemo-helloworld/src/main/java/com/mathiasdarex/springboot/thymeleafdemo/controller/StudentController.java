package com.mathiasdarex.springboot.thymeleafdemo.controller;

import com.mathiasdarex.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // To inject data from the properties file we can use @Value
    @Value("${countries}")
    private List<String> countries;

    @GetMapping("showStudentForm")
    public String showForm(Model theModel) {

        // create a new student object
        Student theStudent = new Student();

        // add that student object as a model attribute - add it to the model
        theModel.addAttribute("student", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        System.out.println("Country: " + theStudent.getCountry());

        return "student-confirmation";
    }

}
