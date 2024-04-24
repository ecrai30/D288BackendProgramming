package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CustomerValidatorImpl.class})
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormValidator {
    String message() default "Failed to add customer: Fields cannot be empty.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
