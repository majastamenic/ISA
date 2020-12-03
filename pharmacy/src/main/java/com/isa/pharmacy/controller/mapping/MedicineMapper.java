package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineDTO;
import com.isa.pharmacy.domain.Medicine;

public class MedicineMapper {

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
