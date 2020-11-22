package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.HospitalRegistrationDto;
import com.isa.pharmacy.domain.Hospital;

public class HospitalMapper {
	
	public static Hospital mapRegistrationDtoToHospital(HospitalRegistrationDto hospitalDto) {
		Hospital hospital = new Hospital();
		hospital.setName(hospitalDto.getName());
		hospital.setEmail(hospitalDto.getEmail());
		return hospital;
	}

}
