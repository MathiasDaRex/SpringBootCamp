package com.mathiasdarex.spring_security_mvc_crud_user_reg_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }


}
