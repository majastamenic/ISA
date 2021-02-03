package com.isa.pharmacy.service;

import java.util.List;
import java.util.regex.Pattern;
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
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(pattern.matcher(user.getEmail()).matches() && existingUser == null){
            return userRepository.save(user);
        }
        throw new AlreadyExistsException(String.format("User with email %s, already exists or is not in required format", user.getEmail()));
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

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
