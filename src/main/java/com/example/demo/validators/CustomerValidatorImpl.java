package com.example.demo.validators;

import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerValidatorImpl implements ConstraintValidator<FormValidator, Customer> {

    @Override
    public void initialize(FormValidator constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        if (customer == null) {
            return false;
        }

        // Your validation logic goes here
        if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
            return false;
        }
        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            return false;
        }

        // Add more validation logic for other fields if needed

        // Return true if all validation passes
        return true;
    }
}


