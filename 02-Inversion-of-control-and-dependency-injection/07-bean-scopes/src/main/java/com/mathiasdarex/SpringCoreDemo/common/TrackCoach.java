package com.mathiasdarex.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



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
