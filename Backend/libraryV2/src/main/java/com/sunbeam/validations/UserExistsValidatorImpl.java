package com.sunbeam.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sunbeam.entities.User;
import com.sunbeam.services.AdminServiceImpl;
import com.sunbeam.services.UserServiceImpl;

@Component
public class UserExistsValidatorImpl implements Validator{

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String email = ((User)target).getuEmail();
		User user = adminService.findUserByUEmail(email);
		if(user != null)
			errors.rejectValue("email", "email.exists", "User already exists");
		
	}

	
}
