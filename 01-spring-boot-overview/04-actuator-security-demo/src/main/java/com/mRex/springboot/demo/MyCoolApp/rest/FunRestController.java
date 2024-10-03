package com.mRex.springboot.demo.MyCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    // expose "/" that returns with "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello dude! the team name is " + teamName + " and the coach is " + coachName;
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 1000k!";
    }

    // expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today will be your lucky day";
    }
}
