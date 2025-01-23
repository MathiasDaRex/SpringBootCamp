package com.mathiasdarex.springboot.thymeleafdemo.controller;

import com.mathiasdarex.springboot.thymeleafdemo.entity.Employee;
import com.mathiasdarex.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String StringshowFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    // @ModelAttribute("employee") is the actual form data passed in using data binding
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        // save the employee
        employeeService.save(theEmployee);


        // use a redirect to prevent duplicate submissions
        // Post/Redirect/Get pattern https://en.wikipedia.org/wiki/Post/Redirect/Get
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to the /employees/list
        return "redirect:/employees/list";
    }

}
