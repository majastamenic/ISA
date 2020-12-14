package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDtoList;
import com.isa.pharmacy.domain.Medicine;

public class MedicineMapper {

	
	public static MedicineDtoList mapMedicineDtoToMedicine(Medicine medicine) {
		MedicineDtoList medicineDto = new MedicineDtoList();
		medicineDto.setCode(medicine.getCode());
		medicineDto.setForm(medicine.getFormOfMedicine().toString());
		medicineDto.setManufactured(medicine.getManufactured());
		medicineDto.setName(medicine.getName());
		medicineDto.setNote(medicine.getNote());
		medicineDto.setPublishingType(medicine.getPublishingType().toString());
		medicineDto.setType(medicine.getTypeOfMedicine());
		return medicineDto;
	}
	
	public Medicine mapMedicineDtoToMedicine(MedicineDto medicineDto) {
		Medicine medicine= new Medicine();
		medicine.setCode(medicineDto.getCode());
		medicine.setComposition(medicineDto.getComposition());
		medicine.setFormOfMedicine(medicineDto.getFormOfMedicine());
		medicine.setManufactured(medicineDto.getManufactured());
		medicine.setName(medicineDto.getName());
		medicine.setNote(medicine.getNote());
		medicine.setPublishingType(medicine.getPublishingType());
		medicine.setReplacementMedicine(medicine.getReplacementMedicine());
		return medicine;
	}
}
