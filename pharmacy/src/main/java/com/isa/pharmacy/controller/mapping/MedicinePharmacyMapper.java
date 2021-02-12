package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;

import java.util.ArrayList;
import java.util.List;

public class MedicinePharmacyMapper {

    public static GetAllMedicinePharmacyDto mapMedicinePharmacyToGetAllMedicinePharmacyDto(MedicinePharmacy medicinePharmacy){
        GetAllMedicinePharmacyDto getAllMedicinePharmacyDto = new GetAllMedicinePharmacyDto();
        getAllMedicinePharmacyDto.setMedicine(MedicineMapper.mapMedicineToMedicineFromPharmacyDto(medicinePharmacy.getMedicine()));
        getAllMedicinePharmacyDto.setPharmacy(PharmacyMapper.mapPharmacyToPharmacyFromMedicinePharmacyDto(medicinePharmacy.getPharmacy()));
        getAllMedicinePharmacyDto.setPrice(medicinePharmacy.getPrice());
        getAllMedicinePharmacyDto.setId(medicinePharmacy.getId());
        getAllMedicinePharmacyDto.setQuantity(medicinePharmacy.getQuantity());
        return getAllMedicinePharmacyDto;
    }

    public static MedicinePharmacy mapGetAllMedicinePharmacyDtoToMedicinePharmacy(GetAllMedicinePharmacyDto getAllMedicinePharmacyDto){
        MedicinePharmacy medicinePharmacy = new MedicinePharmacy();
        medicinePharmacy.setMedicine(MedicineMapper.mapMedicineFromPharmacyToMedicine(getAllMedicinePharmacyDto.getMedicine()));
        medicinePharmacy.setPharmacy(PharmacyMapper.mapPharmacyFromMedicinePharmacyDtoToPharmacy(getAllMedicinePharmacyDto.getPharmacy()));
        medicinePharmacy.setPrice(getAllMedicinePharmacyDto.getPrice());
        medicinePharmacy.setId(getAllMedicinePharmacyDto.getId());
        medicinePharmacy.setQuantity(getAllMedicinePharmacyDto.getQuantity());
        return medicinePharmacy;
    }

    public static MedicinePharmacyDto mapMedicinePharmacyToMedicinePharmacyDto(MedicinePharmacy medicinePharmacy){
        MedicinePharmacyDto medicinePharmacyDto = new MedicinePharmacyDto();
        medicinePharmacyDto.setPrice(medicinePharmacy.getPrice());
        medicinePharmacyDto.setQuantity(medicinePharmacy.getQuantity());
        medicinePharmacyDto.setMedicine(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), medicinePharmacy.getPharmacy().getName()));
        medicinePharmacyDto.setPharmacyName(medicinePharmacy.getPharmacy().getName());
        return medicinePharmacyDto;
    }

    public static MedicinePharmacy mapMedicinePharmacyDtoToMedicinePharmacy(MedicinePharmacyDto medicinePharmacyDto, Pharmacy pharmacy){
        MedicinePharmacy medicinePharmacy = new MedicinePharmacy();
        medicinePharmacy.setPrice(medicinePharmacyDto.getPrice());
        medicinePharmacy.setQuantity(medicinePharmacyDto.getQuantity());
        medicinePharmacy.setMedicine(MedicineMapper.mapMedicineDtoToMedicine(medicinePharmacyDto.getMedicine()));
        medicinePharmacy.setPharmacy(pharmacy);
        return medicinePharmacy;
    }

    public static List<MedicinePharmacyDto> mapListMedicinePharmacyToMedicinePhDto(List<MedicinePharmacy> medPh){
        List<MedicinePharmacyDto> mappedMedPh = new ArrayList<>();
        for(MedicinePharmacy m : medPh)
            mappedMedPh.add(mapMedicinePharmacyToMedicinePharmacyDto(m));
        return mappedMedPh;
    }
}
