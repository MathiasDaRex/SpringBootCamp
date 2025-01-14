package com.mathiasdarex.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }


    // need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data
    // and add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create a message
        String result = "Hi! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    // instead of passing in the HttpServletRequest, we make use of the @RequestParam annotation
    // to bind the HTML form field "studentName"-s value to "TheName". Spring automatically does that.

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // here spring automatically reads the studentName from the model

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create a message
        String result = "Hello wanderer, it's v3! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
