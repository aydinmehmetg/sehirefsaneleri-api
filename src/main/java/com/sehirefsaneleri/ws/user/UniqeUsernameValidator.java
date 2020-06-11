package com.sehirefsaneleri.ws.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqeUsernameValidator implements ConstraintValidator<UniqeUserName, String>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
		
			return false;
		}
		
		return true;
	}

}
