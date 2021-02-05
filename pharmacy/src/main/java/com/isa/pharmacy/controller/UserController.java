package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.PasswordChangeDto;
import com.isa.pharmacy.controller.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.UserMapper;
import com.isa.pharmacy.domain.users.User;
import com.isa.pharmacy.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        return user;
    }


    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/password")
    public User updateUser(@RequestBody UserDto userDto){
        User user = UserMapper.mapUserDtoToUser(userDto);
        return userService.updateUserPassword(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto) throws Exception {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        User user = new User();
        if ((!email.equals("")) && (!password.equals("")))
            user = UserMapper.mapLoginDtoToUser(loginDto);
        if (user == null)
            throw new Exception("Bad request");
        return userService.login(user);
    }

    @PutMapping("/updatePassword")
    public User updatePassword(@RequestBody PasswordChangeDto passwordDto){
        return userService.updatePassword(passwordDto);
    }

    @GetMapping("/info/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){return userService.updateUser(user);}

}