package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.users.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.repository.PharmacyAdminRepository;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyAdminService implements IPharmacyAdminService {
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;
    @Autowired
    private IUserService userService;

    public PharmacyAdmin registration(PharmacyAdmin pharmacyAdmin) {
        PharmacyAdmin existingUser = pharmacyAdminRepository.findPharmacyAdminByUser_email(pharmacyAdmin.getUser().getEmail());
        if (existingUser == null) {
            userService.create(pharmacyAdmin.getUser());
            return pharmacyAdminRepository.save(pharmacyAdmin);
        }
        throw new AlreadyExistsException(String.format("User with email %s, already exists", pharmacyAdmin.getUser().getEmail()));
    }

    public List<PharmacyAdmin> findAll(){
        List<PharmacyAdmin> pharmacyAdminList = pharmacyAdminRepository.findAll();
        if(pharmacyAdminList.isEmpty())
            throw new NotFoundException("There is no pharmacy admins in pharmacy system");
        return pharmacyAdminList;
    }

    //TODO: Ne postoji u Iservice-u
    public PharmacyAdmin updateAdmin(PharmacyAdmin pharmacyAdmin){
        PharmacyAdmin admin = pharmacyAdminRepository.findPharmacyAdminById(pharmacyAdmin.getId());
        if(admin == null)
            throw new NotFoundException("Pharmacy admin doens't exists.");
        admin.setUser(pharmacyAdmin.getUser());
        pharmacyAdminRepository.save(pharmacyAdmin);
        return admin;
    }

    public CreatePhAdminDto findPharmacyAdminByEmail(String email){
        PharmacyAdmin pharmacyAdmin = getByEmail(email);
        return PharmacyAdminMapper.mapPharmacyAdminToPharmacyAdminDto(pharmacyAdmin);
    }

    public List<PharmacyAdmin> findPharmacyAdminByPharmacy(String pharmacyName){
        List<PharmacyAdmin> pharmacyAdmins = new ArrayList<>();
        for(PharmacyAdmin pa: findAll()){
            if(pa.getPharmacy().getName().equalsIgnoreCase(pharmacyName))
                pharmacyAdmins.add(pa);
        }
        return pharmacyAdmins;
    }

    public PharmacyAdmin getByEmail(String email){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminRepository.findPharmacyAdminByUser_email(email);
        if(pharmacyAdmin == null)
            throw new NotFoundException("Pharmacy admin with email "+email+" doesn't exists.");
        return pharmacyAdmin;
    }
}
