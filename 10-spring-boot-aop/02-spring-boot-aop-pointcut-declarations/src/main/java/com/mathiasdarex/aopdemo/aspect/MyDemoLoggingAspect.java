package com.mathiasdarex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    int x = 0;

    // Pointcut expression declaration for reusability
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        x++;
        System.out.println("\n========>>>>>>> Executing @Before advice on method");
        System.out.println("Times run: " + x);

    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n========>>>>>>> Performing fancy API analytics");
    }

}
