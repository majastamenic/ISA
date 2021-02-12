package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.users.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.users.domain.PharmacyAdmin;

import java.util.List;

public interface IPharmacyAdminService {

     PharmacyAdmin registration(PharmacyAdmin pharmacyAdmin);

     List<PharmacyAdmin> findAll();

     CreatePhAdminDto findPharmacyAdminByEmail(String email);

     List<PharmacyAdmin> findPharmacyAdminByPharmacy(String pharmacyName);

     PharmacyAdmin getByEmail(String email);
}
