package com.isa.pharmacy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    Pharmacy findPharmacyByName(String name);

    Pharmacy save(Pharmacy pharmacy);

    List<Pharmacy> findAll();
}
