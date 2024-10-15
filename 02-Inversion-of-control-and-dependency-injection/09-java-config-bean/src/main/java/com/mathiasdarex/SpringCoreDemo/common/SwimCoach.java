package com.mathiasdarex.SpringCoreDemo.common;

// We not use the @Component annotation on purpose
// BUT we have to make a config class to make that work.

// The java configured beans mostly used when we want third-party classes, where we don't have the source code
// But we can interact with them this way, expose them as a Spring bean.

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
