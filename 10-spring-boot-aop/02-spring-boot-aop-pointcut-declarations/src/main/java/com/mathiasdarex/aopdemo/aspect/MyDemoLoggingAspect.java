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

    // create a pointcut for getter methods
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        x++;
        System.out.println("\n========>>>>>>> Executing @Before advice on method");
        System.out.println("Times run: " + x);

    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n========>>>>>>> Performing fancy API analytics");
    }

}
