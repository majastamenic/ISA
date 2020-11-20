package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.domain.User;

public class UserMapper {
	
	public static User mapRegistrationDtoToUser(RegistrationDto registrationDto) {
		User user = new User();
		user.setPassword(registrationDto.getPassword());
		user.setUsername(registrationDto.getUsername());
		return user;
	}
	
	

}
