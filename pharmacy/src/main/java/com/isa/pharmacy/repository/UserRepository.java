package com.isa.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
	
	User findByEmail(String email);
	
	User findUserById(Long id);
	
	List<User> findAll();
	
}
