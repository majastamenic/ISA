package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.domain.PharmacyAdmin;
import com.isa.pharmacy.repository.PharmacyAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyAdminService {
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;

    public PharmacyAdmin save(PharmacyAdmin pharmacyAdmin){ return pharmacyAdminRepository.save(pharmacyAdmin); }

    public List<PharmacyAdmin> findAll(){ return pharmacyAdminRepository.findAll();}

    public PharmacyAdmin updateAdmin(PharmacyAdmin pharmacyAdmin){
        PharmacyAdmin admin = pharmacyAdminRepository.findPharmacyAdminById(pharmacyAdmin.getId());
        admin.setName(pharmacyAdmin.getName());
        admin.setSurname(pharmacyAdmin.getSurname());
        admin.setAddress(pharmacyAdmin.getAddress());
        admin.setCity(pharmacyAdmin.getCity());
        admin.setCountry(pharmacyAdmin.getCountry());
        admin.setPhone(pharmacyAdmin.getPhone());
        admin.setEmail(pharmacyAdmin.getEmail());
        admin.setFirstLog(false);
        return admin;
    }
}
