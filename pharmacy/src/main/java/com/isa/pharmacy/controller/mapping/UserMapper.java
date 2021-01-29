package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.User;
import net.bytebuddy.utility.RandomString;

public class UserMapper {

    public static User mapRegistrationDtoToUser(RegistrationDto registrationDto) {
        User user = new User();
        if(registrationDto.getPassword().equals(registrationDto.getPasswordAgain()))
            user.setPassword(registrationDto.getPassword());
        else
            throw new NotFoundException(String.format("Wrong password"));
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setAddress(registrationDto.getAddress());
        user.setCity(registrationDto.getCity());
        user.setCountry(registrationDto.getCountry());
        user.setPhone(registrationDto.getPhone());
        user.setVerificationCode(RandomString.make(10));
        user.setActive(false);
        return user;
    }

    public static User mapLoginDtoToUser(LoginDto loginDto) {
        User user = new User();
        user.setPassword(loginDto.getPassword());
        user.setEmail(loginDto.getEmail());
        return user;
    }


}
