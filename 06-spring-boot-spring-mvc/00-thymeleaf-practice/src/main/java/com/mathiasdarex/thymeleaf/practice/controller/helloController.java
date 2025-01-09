package com.mathiasdarex.thymeleaf.practice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {

    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloworld";
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        return "numbersform";
    }

    @RequestMapping("/calculate")
    public String  calculateInput(HttpServletRequest request, Model model) {

        // read first number
        int x1 = Integer.parseInt(request.getParameter("x1"));
        System.out.println(x1);
        // read second number
        int x2 = Integer.parseInt(request.getParameter("x2"));
        System.out.println(x2);
        // add them together
        int x3 = x1 + x2;
        System.out.println(x3);
        // add it to the model
        model.addAttribute("sum", x3);

        return "helloworld";
    }



}
