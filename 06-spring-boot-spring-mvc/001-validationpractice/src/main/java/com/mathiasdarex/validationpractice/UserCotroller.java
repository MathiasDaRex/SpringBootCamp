package com.mathiasdarex.validationpractice;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCotroller {

    @GetMapping("/")
    public String showRegisterForm(Model myModel){
        myModel.addAttribute("user", new User());
        return "reg-form";
    }

    @PostMapping("processForm")
    public String processForm(@Valid @ModelAttribute("user") User theUser,
                              BindingResult theBindingResult) {

        System.out.println("User name : |" +theUser.getUserName() + "|" );
        System.out.println("Password: |" + theUser.getPassword() + "|");

        System.out.println("Binding result: " + theBindingResult.toString());
        System.out.println("\n------\n");

        if(theBindingResult.hasErrors()) {
            return "reg-form";
        } else {
            return "user-confirmation";
        }
    }

}
