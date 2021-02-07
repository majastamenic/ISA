package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.users.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.repository.PharmacyAdminRepository;
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
        PharmacyAdmin existingUser = pharmacyAdminRepository.findPharmacyAdminByUser_email(pharmacyAdmin.getUser().getEmail());
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
        pharmacyAdminRepository.save(pharmacyAdmin);
        return admin;
    }

    public CreatePhAdminDto findPharmacyAdminByEmail(String email){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminRepository.findPharmacyAdminByUser_email(email);
        return PharmacyAdminMapper.mapPharmacyAdminToPharmacyAdminDto(pharmacyAdmin);
    }

    public PharmacyAdmin getByEmail(String email){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminRepository.findPharmacyAdminByUser_email(email);
        if(pharmacyAdmin == null)
            throw new NotFoundException("PharmacyAdmin with email "+email+" doesn't exists.");
        return pharmacyAdmin;
    }
}
