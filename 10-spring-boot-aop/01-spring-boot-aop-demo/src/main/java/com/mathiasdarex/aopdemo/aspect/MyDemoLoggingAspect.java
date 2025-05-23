package com.mathiasdarex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    int x = 0;

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        x++;
        System.out.println("\n========>>>>>>> Executing @Before advice on addAccount()");
        System.out.println("Times run: " + x);

    }

}
