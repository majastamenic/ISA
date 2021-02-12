package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Admin;
import com.isa.pharmacy.users.service.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system_admin")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IEmailService emailService;

    @PostMapping
    public Admin registration(@RequestBody RegistrationDto registrationDto) {
        Admin admin = adminService.registration(UserMapper.mapRegistrationDtoToAdmin(registrationDto));
        try {
            emailService.activationEmail(admin.getUser());
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
        return admin;
    }
}
