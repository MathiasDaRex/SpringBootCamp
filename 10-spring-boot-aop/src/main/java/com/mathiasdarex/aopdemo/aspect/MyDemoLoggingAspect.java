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

    // match addAccount method only in accountDAO class
    //@Before("execution(public void com.mathiasdarex.aopdemo.dao.AccountDAO.addAccount())")
    //

    // match method starting with "add" in any class
    //@Before("execution(public void add*())")

    // matching any return type (modifier (public) is optional, if we have all, we don't need to add * to the beginning)
    // @Before("execution(* add*())")

    // Match method with "Account" Param type
    @Before("execution(* add*(com.mathiasdarex.aopdemo.Account))")
    public void beforeAddAccountAdvice() {
        x++;
        System.out.println("\n========>>>>>>> Executing @Before advice on method");
        System.out.println("Times run: " + x);

    }

}
