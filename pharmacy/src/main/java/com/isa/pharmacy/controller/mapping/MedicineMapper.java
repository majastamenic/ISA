package com.isa.pharmacy.controller.mapping;


import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;

public class MedicineMapper {

    public static Medicine mapMedicineDtoToMedicine(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setCode(medicineDto.getCode());
        medicine.setComposition(medicineDto.getComposition());
        medicine.setFormOfMedicine(medicineDto.getFormOfMedicine());
        medicine.setManufactured(medicineDto.getManufactured());
        medicine.setName(medicineDto.getName());
        medicine.setNote(medicineDto.getNote());
        medicine.setPublishingType(medicineDto.getPublishingType());
        medicine.setReplacementMedicines(medicineDto.getAlternative());
        return medicine;
    }

    public static MedicineDto mapMedicineToMedicineDto(Medicine medicine, String pharmacyName) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setCode(medicine.getCode());
        medicineDto.setName(medicine.getName());
        medicineDto.setTypeOfMedicine(medicine.getTypeOfMedicine());
        medicineDto.setFormOfMedicine(medicine.getFormOfMedicine());
        medicineDto.setComposition(medicine.getComposition());
        medicineDto.setManufactured(medicine.getManufactured());
        medicineDto.setPublishingType(medicine.getPublishingType());
        medicineDto.setAlternative(medicine.getReplacementMedicines());
        medicineDto.setNote(medicine.getNote());
        for (MedicinePharmacy medicinePharmacy : medicine.getMedicinePharmacy()) {
            if (medicinePharmacy.getPharmacy().getName().toLowerCase().equals(pharmacyName.toLowerCase())) {
                medicineDto.setPharmacyName(medicinePharmacy.getPharmacy().getName());
                medicineDto.setPrice(medicinePharmacy.getPrice());
                medicineDto.setAmount(medicinePharmacy.getQuantity());
                break;
            }
        }
        return medicineDto;
    }
}
