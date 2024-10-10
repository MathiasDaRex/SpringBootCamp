package com.mathiasdarex.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Lazy annottated classes only create a bean when it's really needed.
// we can set it up locally if we want to

@Component
@Lazy
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K!";
    }
}
