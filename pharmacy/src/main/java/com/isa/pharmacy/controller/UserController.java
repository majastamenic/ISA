package com.isa.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.UserMapper;
import com.isa.pharmacy.domain.User;
import com.isa.pharmacy.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView getUsers() {
		return null;
//		Collection<User> users;
//		return new ModelAndView("listUser", "users", users);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginDto loginDto) {
		User user = UserMapper.mapLoginDtoToUser(loginDto);
		return userService.login(user);
	}
	
	@PostMapping
	public User registration(@RequestBody RegistrationDto registrationDto) {
		User user = UserMapper.mapRegistrationDtoToUser(registrationDto);
		return userService.create(user);
	}
	// /user/1
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		if(user == null) {
			throw new NotFoundException(String.format("User with id %s not found", id));
		}
		return user;
	}
}
//user/login 