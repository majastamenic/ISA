package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Profile.Admin;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserService userService;

    public Admin registration(Admin admin) {
        User existingUser = userService.getByEmail(admin.getUser().getEmail());
        if (existingUser == null) {
            userService.create(admin.getUser());
            return adminRepository.save(admin);
        }
        throw new AlreadyExistsException(String.format("Admin with email %s, already exists", admin.getUser().getEmail()));
    }
}
