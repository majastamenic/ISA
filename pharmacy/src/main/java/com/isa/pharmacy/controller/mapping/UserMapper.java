package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.domain.User;

public class UserMapper {
	
	public static User mapRegistrationDtoToUser(RegistrationDto registrationDto) {
		User user = new User();
		user.setPassword(registrationDto.getPassword());
		user.setEmail(registrationDto.getEmail());
		user.setName(registrationDto.getName());
		user.setSurname(registrationDto.getSurname());
		user.setAddress(registrationDto.getAddress());
		user.setCity(registrationDto.getCity());
		user.setCountry(registrationDto.getCountry());
		user.setPhone(registrationDto.getPhone());
		return user;
	}

	public static User mapLoginDtoToUser(LoginDto loginDto) {
		User user = new User();
		user.setPassword(loginDto.getPassword());
		user.setEmail(loginDto.getEmail());
		return user;
	}
	
	

}
