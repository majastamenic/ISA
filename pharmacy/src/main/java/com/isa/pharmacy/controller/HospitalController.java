package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.service.MedicinePharmacyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.controller.mapping.HospitalMapper;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.service.HospitalService;


@RestController
@RequestMapping("/HospitalApi")
@CrossOrigin(value = "http://localhost:4200")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private MedicinePharmacyService medicinePharmacyService;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public Hospital registration(@RequestBody HospitalManagerRegistrationDto registrationHospitalDto) {
		Hospital hospital = this.hospitalService.getByEmail(registrationHospitalDto.getEmail());
		hospital = HospitalMapper.mapRegistrationDtoToHospital(registrationHospitalDto, hospital);
		hospital = hospitalService.create(hospital);
		try {
			emailService.sendApiKey(hospital.getEmail(), "1dfre-astfc-hfe5g-a65Sd");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		return hospital;
	}
	
	@GetMapping
	public List<Hospital> getAll(){
		return hospitalService.getAll();
	}

	@GetMapping("/getAllMedications/{pharmacyName}")
	public List<MedicineDto> getAllMedicineInPharmacy(@PathVariable("pharmacyName") String pharmacyName){
		List<MedicineDto> medicineDtoList = new ArrayList<>();
		for(MedicinePharmacy medicinePharmacy: medicinePharmacyService.getAllWithPharmacyName(pharmacyName)){
			medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToMedicineDto(medicinePharmacy));
		}
		return medicineDtoList;
	}

	@GetMapping("/checkAvailability/{medicineName}/{pharmacyName}")
	public Boolean checkAvailability(@PathVariable("medicineName") String medicineName, @PathVariable("pharmacyName") String pharmacyName){
		return hospitalService.checkAvailability(medicineName, pharmacyName);
	}
	
}
