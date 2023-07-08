package com.planner.block.validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.planner.block.form.UserForm;



@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// Check if the first name and last name are empty or whitespace
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.required");
        
        UserForm form = (UserForm) target;
        
        if (!errors.hasFieldErrors("password") && !errors.hasFieldErrors("confirmPassword")) {
        	if (!form.getPassword().equals(form.getConfirmPassword())) {
        		errors.rejectValue("confirmPassword", "password.mismatch");
        	}
        }
	}

}
