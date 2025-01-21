package com.mathiasdarex.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Constraint validated by our helper class with its business logic
// Target: where we can use that annotation - here on methods and fields
// Retention - how long the annotation be stored or used


@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define default groups - where we can group validation constrains together
    public Class<?>[] groups() default {};

    // define default payloads - additional information about the validation error
    // (severity level, error code, ect...)
    public Class<? extends Payload>[] payload() default {};

}

