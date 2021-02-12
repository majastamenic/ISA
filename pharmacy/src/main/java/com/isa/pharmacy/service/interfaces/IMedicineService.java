package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.AvailabilityMedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMedicineService {
     Medicine create(Medicine medicine);

     void delete(Medicine medicine);

     Page<Medicine> filterMedicines(int pageSize, int numPage, String name, Double startPrice, Double endPrice,
                                          List<Long> pharmacies, String typeOfMedicine, String manufactured,
                                          String composition, FormOfMedicine formOfMedicine, MedicinePublishingType publishingType);

     Medicine findById(Long id);

     Medicine findByName(String name);

     Page<Medicine> getAll(int numPage, int pageSize);

     List<Medicine> getAll();

     List<MedicineDto> getAllMedicines();

     List<AvailabilityMedicineDto> checkAvailabilityMedicines(String pharmacyName, List<String> meds);

     List<AvailabilityMedicineDto> checkAvailabilityMedicinesByPharmacist(String pharmacistEmail, List<String> meds);

     List<AvailabilityMedicineDto> checkingMedicines(Pharmacy pharmacy, List<String> meds);

     void notifyPharmacyAdminsAboutMedicine(List<PharmacyAdmin> pharmacyAdmins, String medicineName);

     MedicineLoyaltyDto changeLoyalty(MedicineLoyaltyDto medicineLoyaltyDto);

     List<Medicine> getMedicinesByNames(List<String> medicinesNames);

     List<Medicine> getAllMedicinesByCode(List<Long> codes);

     List<String> getAllMedicinesById(List<Long> ids);

     List<Medicine> decreaseQuantityInPharmacy(List<Medicine> meds, String pharmacyName);

     /* Method changes amount of medicine with name medicineName from pharmacy
      * with name pharmacyName. It adds or subtracts dependent on amount param sign.
      **/
     void changeAmount(String medicineName, int amount, String pharmacyName);

     void update(Medicine medicine);

     MedicineDto findMedicineSpecification(String name);
}
