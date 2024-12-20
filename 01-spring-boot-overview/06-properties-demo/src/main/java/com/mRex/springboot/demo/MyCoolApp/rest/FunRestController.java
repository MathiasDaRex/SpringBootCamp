package com.mRex.springboot.demo.MyCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject poperties for coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach :" + coachName + ", Team name: " + teamName;
    }

    // expose "/" that returns with "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello dude!";
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
