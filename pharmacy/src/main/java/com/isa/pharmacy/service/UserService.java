package com.isa.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.User;
import com.isa.pharmacy.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser == null) {
			return userRepository.save(user);
		}
		throw new AlreadyExistsException(String.format("User with username %s, already exists", user.getUsername()));
	}

	public User getById(Long id) {
		User user = userRepository.findUserById(id);
		return user;
	}
}
