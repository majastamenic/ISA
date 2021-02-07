package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.PrescriptionDto;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionMapper {

    public static PrescriptionDto mapPrescriptionToPrescriptionDto(Prescription prescription){
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        if(prescription != null){
            prescriptionDto.setId(prescription.getId());
            prescriptionDto.setDays(prescription.getDays());
            prescriptionDto.setDiagnoses(prescription.getDiagnoses());
            List<MedicinePharmacyDto> meds = new ArrayList<>();
            for(MedicinePharmacy mp : prescription.getMedicines()){
                MedicinePharmacyDto mpDto = MedicinePharmacyMapper.mapMedicinePharmacyToMedicinePharmacyDto(mp);
                meds.add(mpDto);
            }
            prescriptionDto.setMedicines(meds);
        }
        return prescriptionDto;
    }
}
