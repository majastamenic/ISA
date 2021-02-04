package com.isa.pharmacy.controller.mapping;


import com.isa.pharmacy.controller.dto.AddMedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineFromPharmacyDto;
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
            if (medicinePharmacy.getPharmacy().getName().equalsIgnoreCase(pharmacyName)) {
                medicineDto.setPharmacyName(medicinePharmacy.getPharmacy().getName());
                medicineDto.setPrice(medicinePharmacy.getPrice());
                medicineDto.setAmount(medicinePharmacy.getQuantity());
                break;
            }
        }
        return medicineDto;
    }

    public static Medicine mapAddMedicineDtoToMedicine(AddMedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setCode(medicineDto.getCode());
        medicine.setName(medicineDto.getName());
        medicine.setTypeOfMedicine(medicineDto.getTypeOfMedicine());
        medicine.setFormOfMedicine(medicineDto.getFormOfMedicine());
        medicine.setComposition(medicineDto.getComposition());
        medicine.setManufactured(medicineDto.getManufactured());
        medicine.setPublishingType(medicineDto.getPublishingType());
        medicine.setReplacementMedicines(medicineDto.getReplacementMedicine());
        medicine.setNote(medicineDto.getNote());
        return medicine;
    }

    public static Medicine mapMedicineFromPharmacyToMedicine(MedicineFromPharmacyDto medicineFromPharmacyDto){
        Medicine medicine = new Medicine();
        medicine.setId(medicineFromPharmacyDto.getId());
        medicine.setName(medicineFromPharmacyDto.getName());
        return medicine;
    }

    public static MedicineFromPharmacyDto mapMedicineToMedicineFromPharmacyDto(Medicine medicine){
        MedicineFromPharmacyDto medicineFromPharmacyDto = new MedicineFromPharmacyDto();
        medicineFromPharmacyDto.setName(medicine.getName());
        medicineFromPharmacyDto.setId(medicine.getId());
        return medicineFromPharmacyDto;
    }
}
