package com.isa.pharmacy.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
	
	User findUserById(Long id);
	
}
