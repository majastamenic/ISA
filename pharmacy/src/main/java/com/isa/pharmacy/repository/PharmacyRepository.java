package com.isa.pharmacy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    Pharmacy findPharmacyByName(String name);

    Pharmacy findPharmacyById(Long id);

    Pharmacy save(Pharmacy pharmacy);

    List<Pharmacy> findAll();

    @Query(value = "select p from Pharmacy p join p.subscribedEmails se where :email = se")
    List<Pharmacy> findPharmaciesBySubscriber(@Param("email")String email);
}
