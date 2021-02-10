package com.isa.pharmacy.repository;


import java.util.List;

import com.isa.pharmacy.domain.MedicineEPrescription;
import com.isa.pharmacy.domain.MedicinePharmacy;
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

    @Query(value = "select p from Pharmacy p, MedicinePharmacy mp join MedicineEPrescription me where me in (:medEprescriptions) and mp.pharmacy = p and mp.medicine.name=me.name and mp.quantity>=me.quantity" )
    List<Pharmacy> findPharmaciesByMedicineEprescription(@Param("medEprescriptions")List<MedicineEPrescription> medEprescriptions);
}
