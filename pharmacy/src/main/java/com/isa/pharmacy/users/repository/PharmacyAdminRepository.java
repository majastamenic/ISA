package com.isa.pharmacy.users.repository;


import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Long> {

    PharmacyAdmin save(PharmacyAdmin pharmacyAdmin);

    List<PharmacyAdmin> findAll();

    PharmacyAdmin findPharmacyAdminById(Long id);

    PharmacyAdmin findPharmacyAdminByUser_email(String email);
}
