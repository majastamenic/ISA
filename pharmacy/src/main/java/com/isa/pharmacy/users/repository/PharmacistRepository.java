package com.isa.pharmacy.users.repository;

import java.util.List;
import com.isa.pharmacy.users.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

    List<Pharmacist> findAll();

    Pharmacist save(Pharmacist p);

    Pharmacist findPharmacistById(Long id);

    Long deletePharmacistById(Long id);

    Pharmacist findPharmacistByUser_email(String email);
}
