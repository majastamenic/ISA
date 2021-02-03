package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Profile.PharmacyAdmin;
import com.isa.pharmacy.repository.PharmacyAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyAdminService {
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;

    public PharmacyAdmin save(PharmacyAdmin pharmacyAdmin){
        return pharmacyAdminRepository.save(pharmacyAdmin); }

    public List<PharmacyAdmin> findAll(){ return pharmacyAdminRepository.findAll();}

    public PharmacyAdmin updateAdmin(PharmacyAdmin pharmacyAdmin){
        PharmacyAdmin admin = pharmacyAdminRepository.findPharmacyAdminById(pharmacyAdmin.getId());
        admin.setUser(pharmacyAdmin.getUser());
        admin.setFirstLog(false);
        pharmacyAdminRepository.save(pharmacyAdmin);
        return admin;
    }
}
