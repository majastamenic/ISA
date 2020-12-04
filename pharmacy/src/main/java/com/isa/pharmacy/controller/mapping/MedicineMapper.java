package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.domain.Medicine;

public class MedicineMapper {
	
	public static MedicineDto mapMedicineDtoToMedicine(Medicine medicine) {
		MedicineDto medicineDto = new MedicineDto();
		medicineDto.setCode(medicine.getCode());
		medicineDto.setForm(medicine.getFormOfMedicine().toString());
		medicineDto.setManufactured(medicine.getManufactured());
		medicineDto.setName(medicine.getName());
		medicineDto.setNode(medicine.getNote());
		medicineDto.setPublishingType(medicine.getPublishingType().toString());
		medicineDto.setType(medicine.getTypeOfMedicine());

		return medicineDto;
	}

}
