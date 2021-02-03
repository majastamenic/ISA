package com.isa.pharmacy.controller.mapping;


import com.isa.pharmacy.controller.dto.LoginDto;
import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Profile.Dermatologist;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.domain.enums.Role;
import net.bytebuddy.utility.RandomString;

public class UserMapper {

    public static Patient mapRegistrationDtoToPatient(RegistrationDto registrationDto) {
        Patient patient = new Patient();
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
        user.setActive(false);
        user.setRole(Role.PATIENT);

        patient.setVerificationCode(RandomString.make(10));
        patient.setUser(user);
        return patient;
    }

    public static User mapLoginDtoToUser(LoginDto loginDto) {
        User user = new User();
        user.setPassword(loginDto.getPassword());
        user.setEmail(loginDto.getEmail());
        return user;
    }

    public static Dermatologist mapRegistrationDtoToDermatologist(RegistrationDto registrationDto) {
        Dermatologist dermatologist = new Dermatologist();
        dermatologist.setUser(mapRegistrationDtoToUser(registrationDto));
        return dermatologist;
    }


    public static RegistrationDto mapUserToRegistrationDto(User user){
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(user.getEmail());
        registrationDto.setPassword(user.getPassword());
        registrationDto.setCity(user.getCity());
        registrationDto.setAddress(user.getAddress());
        registrationDto.setCountry(user.getCountry());
        registrationDto.setPhone(user.getPhone());
        return registrationDto;
    }

    public static User mapRegistrationDtoToUser(RegistrationDto registrationDto){
        User user = new User();
        user.setPassword(RandomString.make(10));
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setAddress(registrationDto.getAddress());
        user.setCity(registrationDto.getCity());
        user.setCountry(registrationDto.getCountry());
        user.setPhone(registrationDto.getPhone());
        user.setActive(false);
        user.setRole(registrationDto.getRole());
        return user;
    }

}
