package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Admin;
import com.isa.pharmacy.users.service.AdminService;
import com.isa.pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system_admin")
@CrossOrigin(value = "http://localhost:4200")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmailService emailService;
    @PostMapping
    public Admin registration(@RequestBody RegistrationDto registrationDto) {
        Admin admin = adminService.registration(UserMapper.mapRegistrationDtoToAdmin(registrationDto));
        emailService.activationEmail(admin.getUser());
        return admin;
    }
}
