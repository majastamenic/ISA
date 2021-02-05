package com.isa.pharmacy.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.users.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    List<User> findAll();

    User save(User u);

}