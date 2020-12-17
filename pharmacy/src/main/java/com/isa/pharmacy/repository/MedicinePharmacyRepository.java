package com.isa.pharmacy.repository;

import java.util.List;

import com.isa.pharmacy.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.MedicinePharmacy;

@Repository
public interface MedicinePharmacyRepository extends JpaRepository<MedicinePharmacy, Long>{
	
	MedicinePharmacy findMedicinePharmacyById(Long id);
	
	MedicinePharmacy findMedicinePharmacyByPrice(double price);
	
	MedicinePharmacy findMedicinePharmacyByQuantity(int quantity);	
	
	List<MedicinePharmacy> findAll();

	List<MedicinePharmacy> getMedicinesFromPharmacy(Pharmacy pharmacy);

	Boolean hasPharmacyMedication(String nameOfMedication);
}
