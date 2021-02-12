package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.*;
import com.isa.pharmacy.users.controller.dto.PasswordChangeDto;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.domain.enums.Role;
import com.isa.pharmacy.users.repository.UserRepository;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = false)
    public User create(User user) {
        try {
            User existingUser = userRepository.findByEmail(user.getEmail());
            if (existingUser != null)
                throw new AlreadyExistsException(String.format("User with email %s, already exists", user.getEmail()));
            Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
            Pattern patternPass = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
            if ((pattern.matcher(user.getEmail()).matches() && patternPass.matcher(user.getPassword()).matches()) || user.getPassword().equals("")) {
                return userRepository.save(user);
            }
        }catch (Exception e){
            throw new BadRequestException("Thread " + e.getMessage());
        }
        throw new UnauthorizeException("Email or passowrd is not in required format");
    }

    @Transactional(readOnly = false)
    public User updateUser(User user){
        User dbUser = getByEmail(user.getEmail());
        dbUser.setName(user.getName());
        dbUser.setSurname(user.getSurname());
        dbUser.setAddress(user.getAddress());
        dbUser.setCity(user.getCity());
        dbUser.setCountry(user.getCountry());
        dbUser.setPhone(user.getPhone());
        return userRepository.save(dbUser);
    }

    @Transactional(readOnly = false)
    public User updateUserPassword(User user){
        User dbUser = getByEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());
        dbUser.setActive(true);
        return userRepository.save(dbUser);
    }

    @Transactional(readOnly = true)
    public User login(User user) {
        User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser == null || (!existingUser.getActive() && existingUser.getRole().equals(Role.PATIENT)) ) {
            throw new UnauthorizeException("Can't find user with email and password");
        }
        return existingUser;
    }

    @Transactional(readOnly = false)
    public User updatePassword(PasswordChangeDto passwordDto){
        User dbUser = getByEmail(passwordDto.getEmail());
        if(!dbUser.getPassword().equals(passwordDto.getOldPass()))
            throw new InvalidActionException("Invalid old password");
        if(!passwordDto.getNewPass().equals(passwordDto.getNewPassRepeat()))
            throw new InvalidActionException("Passwords are not equal");
        dbUser.setPassword(passwordDto.getNewPass());
        return userRepository.save(dbUser);
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        return user;
    }

    @Transactional(readOnly = true)
    public User getByEmail(String email){
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new NotFoundException("User with email " + email + "doesn't exists");
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            throw new NotFoundException("There is no user in pharmacy system.");
        return users;
    }

    @Transactional(readOnly = false)
    public User save(User user){return userRepository.save(user);}
}
