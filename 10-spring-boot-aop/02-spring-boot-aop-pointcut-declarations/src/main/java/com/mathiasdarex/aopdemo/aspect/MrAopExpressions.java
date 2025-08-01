package com.mathiasdarex.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// If we only have pointcuts then @Aspect is optional
// Only required if you add advices in this class (@Before, @After...)

@Aspect
public class MrAopExpressions {

    // Pointcut expression declaration for reusability
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.mathiasdarex.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
