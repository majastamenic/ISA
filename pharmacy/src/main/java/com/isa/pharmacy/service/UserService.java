package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.PasswordChangeDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.exception.UnauthorizeException;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.domain.enums.Role;
import com.isa.pharmacy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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

    public User updateUser(User user){
        User dbUser = userRepository.findByEmail(user.getEmail());
        if(dbUser == null)
            throw new NotFoundException("User not found");
        dbUser.setName(user.getName());
        dbUser.setSurname(user.getSurname());
        dbUser.setAddress(user.getAddress());
        dbUser.setCity(user.getCity());
        dbUser.setCountry(user.getCountry());
        dbUser.setPhone(user.getPhone());
        dbUser.setActive(true);
        return userRepository.save(dbUser);
    }

    public User login(User user) {
        User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null || (!existingUser.getActive() && existingUser.getRole().equals(Role.PATIENT)) ) {
            throw new UnauthorizeException("Can't find user with email and password");
        }
        return existingUser;
    }

    public User updatePassword(PasswordChangeDto passwordDto){
        User dbUser = userRepository.findByEmail(passwordDto.getEmail());
        if(dbUser == null)
            throw new NotFoundException("User not found");
        if(!dbUser.getPassword().equals(passwordDto.getOldPass()))
            throw new RuntimeException("Invalid old password");
        if(!passwordDto.getNewPass().equals(passwordDto.getNewPassRepeat()))
            throw new RuntimeException("Passwords are not equal");
        dbUser.setPassword(passwordDto.getNewPass());
        return userRepository.save(dbUser);
    }

    public User getById(Long id) {
        return userRepository.findUserById(id);
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAll() { return userRepository.findAll(); }
}
