package com.isa.pharmacy.service;

import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private MedicinePharmacyService medicinePharmacyService;

	public Hospital create(Hospital hospital) {
		Hospital existingHospital = hospitalRepository.findByEmail(hospital.getEmail());
		if (existingHospital == null) {
			return hospitalRepository.save(hospital);
		}
		throw new AlreadyExistsException(String.format("Hospital with email %s, already registered", hospital.getEmail()));
	}

	public Hospital getByEmail(String email) {
		return hospitalRepository.findByEmail(email);
	}
	
	public List<Hospital> getAll(){
		return hospitalRepository.findAll();
	}

	public MedicinePharmacy checkAvailability(String medicineName, String pharmacyName){
		for(MedicinePharmacy medicinePharmacy: medicinePharmacyService.getAllWithPharmacyName(pharmacyName)){
			if(medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
				return medicinePharmacy;
		}
		return null;
	}

	public MedicineDto orderMedicine(String medicineName, int amount, String pharmacyName){
		for(MedicinePharmacy medicinePharmacy: medicinePharmacyService.getAllWithPharmacyName(pharmacyName)){
			if(medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName)
				&& medicinePharmacy.getQuantity() >= amount){
				medicinePharmacy.setQuantity(medicinePharmacy.getQuantity() - amount);			// TODO: smanjiti u bazi/sacuvati
				return MedicinePharmacyMapper.mapMedicinePharmacyToMedicineDto(medicinePharmacy);	// Losa povratna vr, treba da vraca amount a ne quantity - amount
			}
		}
		return null;
	}

}
