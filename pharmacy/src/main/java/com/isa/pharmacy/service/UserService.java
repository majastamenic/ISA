package com.isa.pharmacy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.UnauthorizeException;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return userRepository.save(user);
        }
        throw new AlreadyExistsException(String.format("User with email %s, already exists", user.getEmail()));
    }

    public User login(User user) {
        User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null || !existingUser.getActive()) {
            throw new UnauthorizeException("Can't find user with email and password");
        }
        return existingUser;
    }

    public User getById(Long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    public List<User> getAll() { return userRepository.findAll(); }

    public User activateProfile(String email, String code){
        User user = userRepository.findByEmail(email);
        if(user != null && !user.getActive() && user.getVerificationCode().equals(code)){
            user.setActive(true);
            userRepository.save(user);
        }
        return user;
    }
}
