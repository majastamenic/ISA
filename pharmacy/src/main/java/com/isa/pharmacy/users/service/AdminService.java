package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.Admin;
import com.isa.pharmacy.users.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserService userService;

    public Admin registration(Admin admin) {
        Admin existingUser = adminRepository.findAdminByUser_email(admin.getUser().getEmail());
        if (existingUser == null) {
            userService.create(admin.getUser());
            return adminRepository.save(admin);
        }
        throw new AlreadyExistsException(String.format("Admin with email %s, already exists", admin.getUser().getEmail()));
    }
}
