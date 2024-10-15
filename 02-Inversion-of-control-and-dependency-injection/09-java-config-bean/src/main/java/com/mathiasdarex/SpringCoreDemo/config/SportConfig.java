package com.mathiasdarex.SpringCoreDemo.config;

import com.mathiasdarex.SpringCoreDemo.common.Coach;
import com.mathiasdarex.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Bean ID will refer to the method name default

    // BUT we can add custom bean ID <- watch out for the qualifier, it has to be the bean ID

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
