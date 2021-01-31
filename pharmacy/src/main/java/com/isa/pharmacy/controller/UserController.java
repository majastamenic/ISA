package com.isa.pharmacy.controller;

import com.isa.pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private EmailService emailService;

    @GetMapping
    public ModelAndView getUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        return user;
    }

    @GetMapping("/valid")
    public User activeProfile(@RequestParam String email, @RequestParam String code){
        return userService.activateProfile(email, code);
    }

    @PostMapping
    public User registration(@RequestBody RegistrationDto registrationDto) {
        User user = userService.create(UserMapper.mapRegistrationDtoToUser(registrationDto));
        emailService.verificationEmail(user);
        return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto) throws Exception {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        User user = null;
        if ((!email.equals("")) && (!password.equals("")))
            user = UserMapper.mapLoginDtoToUser(loginDto);
        if (user.equals(null))
            throw new Exception("Bad request");
        return userService.login(user);
    }


}