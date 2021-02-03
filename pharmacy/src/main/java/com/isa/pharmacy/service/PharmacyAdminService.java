package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;
import com.isa.pharmacy.domain.Profile.Supplier;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.repository.PharmacyAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyAdminService {
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;
    @Autowired
    private UserService userService;

    public PharmacyAdmin registration(PharmacyAdmin pharmacyAdmin) {
        User existingUser = userService.getByEmail(pharmacyAdmin.getUser().getEmail());
        if (existingUser == null) {
            userService.create(pharmacyAdmin.getUser());
            return pharmacyAdminRepository.save(pharmacyAdmin);
        }
        throw new AlreadyExistsException(String.format("User with email %s, already exists", pharmacyAdmin.getUser().getEmail()));
    }

    public List<PharmacyAdmin> findAll(){ return pharmacyAdminRepository.findAll();}

    public PharmacyAdmin updateAdmin(PharmacyAdmin pharmacyAdmin){
        PharmacyAdmin admin = pharmacyAdminRepository.findPharmacyAdminById(pharmacyAdmin.getId());
        admin.setUser(pharmacyAdmin.getUser());
        admin.setFirstLog(false);
        pharmacyAdminRepository.save(pharmacyAdmin);
        return admin;
    }
}
