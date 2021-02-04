package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.domain.MedicinePharmacy;

public class MedicinePharmacyMapper {

    public static GetAllMedicinePharmacyDto mapMedicinePharmacyToGetAllMedicinePharmacyDto(MedicinePharmacy medicinePharmacy){
        GetAllMedicinePharmacyDto getAllMedicinePharmacyDto = new GetAllMedicinePharmacyDto();
        getAllMedicinePharmacyDto.setMedicine(medicinePharmacy.getMedicine());
        getAllMedicinePharmacyDto.setPharmacy(medicinePharmacy.getPharmacy());
        getAllMedicinePharmacyDto.setPrice(medicinePharmacy.getPrice());
        getAllMedicinePharmacyDto.setId(medicinePharmacy.getId());
        getAllMedicinePharmacyDto.setQuantity(medicinePharmacy.getQuantity());
        return getAllMedicinePharmacyDto;
    }

    public static MedicinePharmacy mapGetAllMedicinePharmacyDtoToMedicinePharmacy(GetAllMedicinePharmacyDto getAllMedicinePharmacyDto){
        MedicinePharmacy medicinePharmacy = new MedicinePharmacy();
        medicinePharmacy.setMedicine(getAllMedicinePharmacyDto.getMedicine());
        medicinePharmacy.setPharmacy(getAllMedicinePharmacyDto.getPharmacy());
        medicinePharmacy.setPrice(getAllMedicinePharmacyDto.getPrice());
        medicinePharmacy.setId(getAllMedicinePharmacyDto.getId());
        medicinePharmacy.setQuantity(getAllMedicinePharmacyDto.getQuantity());
        return medicinePharmacy;
    }
}
