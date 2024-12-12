package com.mathiasdarex.springboot.thymeleafdemo.controller;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // create mapping for "/hello"

    @GetMapping("/hello")
    public String SayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());


        // We have thymeleaf dependency in maven POM, so springboot
        // will autoconfigure to use thymeleaf, and it
        // returns with /templates/helloworld.html

        return "helloworld";
    }

}
