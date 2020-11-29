package com.isa.pharmacy.controller.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.isa.pharmacy.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.domain.Pharmacy;

public class HospitalMapper {
	
	public static Hospital mapRegistrationDtoToHospital(HospitalManagerRegistrationDto hospitalDto, Hospital hospital) {
		if (hospital == null) 
		{
			hospital = new Hospital();
			hospital.setPharmacies(new ArrayList<>());
			hospital.setName(hospitalDto.getName());
			hospital.setEmail(hospitalDto.getEmail());
		}
		
		//Kupi sve id-jeve apoteka i stavlja ih u listu
		List<Long> pharmaciesIds = hospital.getPharmacies().stream().map(Pharmacy::getId).collect(Collectors.toList());
		if (!(pharmaciesIds.contains(hospitalDto.getPharmacy().getId())))
			hospital.getPharmacies().add(hospitalDto.getPharmacy());

		return hospital;
	}

}
