package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.Admin;
import com.isa.pharmacy.users.repository.AdminRepository;
import com.isa.pharmacy.users.service.interfaces.IAdminService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private IUserService userService;

    public Admin registration(Admin admin) {
        Admin existingUser = adminRepository.findAdminByUser_email(admin.getUser().getEmail());
        if (existingUser == null) {
            userService.create(admin.getUser());
            return adminRepository.save(admin);
        }
        throw new AlreadyExistsException(String.format("Admin with email %s, already exists", admin.getUser().getEmail()));
    }
}
