package com.isa.pharmacy.repository;


import com.isa.pharmacy.domain.Profile.PharmacyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Long> {

    PharmacyAdmin save(PharmacyAdmin offer);

    List<PharmacyAdmin> findAll();

    PharmacyAdmin findPharmacyAdminById(Long id);
}
