package com.mathiasdarex.SpringCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    // with bean lifecycle methods we can add our own custom code
    // during bean initialization and destruction of the bean

    // define our init method
    @PostConstruct
    public void doMyStartupStaff() {
        System.out.println("In doMyStartupStff():  " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff():  " + getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :)";
    }
}
