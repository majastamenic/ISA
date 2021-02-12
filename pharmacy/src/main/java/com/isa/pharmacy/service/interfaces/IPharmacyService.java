package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.domain.*;
import java.util.List;

public interface IPharmacyService {
     Pharmacy save(Pharmacy p);

     Pharmacy getById(Long id);

     List<GetAllPharmaciesDto> getAll();

     List<Medicine> getMedicinesFromPharmacy(String pharmacyName);

     int hasPharmacyMedication(String pharmacyName, String medicineName);

     Medicine checkAvailability(String medicineName, String pharmacyName);

     List<MedicineDto> checkAvailabilities(List<String> medicinesName, String pharmacyName);

     MedicineDto orderMedicine(String medicineName, int amount, String pharmacyName);

     List<MedicineDto> orderMedicines(List<MedicineOrderDto> medicineOrderDtoList, String pharmacyName);

     List<MedicineDto> getMedicineListFromPharmacy(String pharmacyName);

     void checkApiKey(String apiKey);

     List<String> getPharmacyName();

     List<Pharmacy> getPharmaciesForCounseling(DateTimeDto eagerDate);

     List<Pharmacy> findPharmaciesBySubEmail(String email);

     void addSubscribe(String email, String phName);

     void unsubscribe(String email, String phName);

     Pharmacy getPharmacyByName(String phName);

     List<PharmacyPriceDto> getPharmacyByEPrescription(EPrescription ePrescription);

     void update(Pharmacy pharmacy);

}
