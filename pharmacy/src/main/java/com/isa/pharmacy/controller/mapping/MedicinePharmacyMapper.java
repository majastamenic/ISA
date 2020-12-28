package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDtoList;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;

public class MedicinePharmacyMapper {

    public static MedicineDto mapMedicinePharmacyToMedicineDto(MedicinePharmacy medicinePharmacy) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setPrice(medicinePharmacy.getPrice());
        medicineDto.setPharmacy(medicinePharmacy.getPharmacy());
        medicineDto.setNote(medicinePharmacy.getMedicine().getNote());
        medicineDto.setName(medicinePharmacy.getMedicine().getName());
        medicineDto.setManufactured(medicinePharmacy.getMedicine().getManufactured());
        medicineDto.setFormOfMedicine(medicinePharmacy.getMedicine().getFormOfMedicine());
        medicineDto.setComposition(medicinePharmacy.getMedicine().getComposition());
        medicineDto.setCode(medicinePharmacy.getMedicine().getCode());
        medicineDto.setPublishingType(medicinePharmacy.getMedicine().getPublishingType());
        medicineDto.setAmount(medicinePharmacy.getQuantity());
        medicineDto.setTypeOfMedicine(medicinePharmacy.getMedicine().getTypeOfMedicine());
        medicineDto.setAlternative(medicinePharmacy.getMedicine().getReplacementMedicine());
        return medicineDto;
    }
}
