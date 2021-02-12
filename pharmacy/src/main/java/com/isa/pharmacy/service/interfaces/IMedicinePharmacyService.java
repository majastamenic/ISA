package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.Patient;

import java.util.List;

public interface IMedicinePharmacyService {
     MedicinePharmacy save(MedicinePharmacy medicinePharmacy);

     List<GetAllMedicinePharmacyDto> getAllMedicinePharmacies();

     List<GetAllMedicinePharmacyDto> getAllMedicinesByPharmacies(Long id);

     List<MedicinePharmacyDto> getMedicinesByPharmacy(String pharmacyName, String email);

     List<MedicinePharmacyDto> getMedicinesByPharmacist(String pharmacistEmail, String patientEmail);

     List<MedicinePharmacyDto> getMedicinesPharmacy(Pharmacy pharmacy, Patient patient);

     List<MedicinePharmacyDto> getMedicinesByCounseling(long id);
}
