package com.mathiasdarex.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // Model allows us to share information between Controllers and view pages(thymeleaf)

    @GetMapping("/")
    public String showForm(Model theModel){

        // attribute name is important cuz that's what we can use in our view pages, forms, ect... - DATA BINDING
        theModel.addAttribute("customer", new Customer());

        return "customer-form"; // logical name of view page - customer-form.html
    }

    // BindingResult holds the results of the validation, if anything fails comes back with an error
    // if everything is successful, we can write our logic to redirect to the wanted page

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {

        if(theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
