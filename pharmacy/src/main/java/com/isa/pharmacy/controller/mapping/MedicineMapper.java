package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineDTO;
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
	
	public Medicine mapMedicineDtoToMedicine(MedicineDTO medicineDTO) {
		Medicine medicine= new Medicine();
		medicine.setCode(medicineDTO.getCode());
		medicine.setComposition(medicineDTO.getComposition());
		medicine.setFormOfMedicine(medicineDTO.getFormOfMedicine());
		medicine.setManufactured(medicineDTO.getManufactured());
		medicine.setName(medicineDTO.getName());
		medicine.setNote(medicine.getNote());
		medicine.setPublishingType(medicine.getPublishingType());
		medicine.setReplacementMedicine(medicine.getReplacementMedicine());
		return medicine;
	}
}
