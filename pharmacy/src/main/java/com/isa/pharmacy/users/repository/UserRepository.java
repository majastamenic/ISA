package com.isa.pharmacy.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.users.domain.User;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    User findUserById(Long id);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    List<User> findAll();

    User save(User user);

}
