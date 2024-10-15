package com.mathiasdarex.SpringCoreDemo.rest;

import com.mathiasdarex.SpringCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In construction: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkoutz")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
