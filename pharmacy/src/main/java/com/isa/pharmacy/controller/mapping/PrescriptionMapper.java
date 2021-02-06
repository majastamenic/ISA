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
        prescriptionDto.setId(prescription.getId());
        prescriptionDto.setNote(prescription.getNote());
        prescriptionDto.setDiagnoses(prescription.getDiagnoses());
        List<MedicinePharmacyDto> meds = new ArrayList<>();
        for(MedicinePharmacy mp : prescription.getMedicines()){
            MedicinePharmacyDto mpDto = MedicinePharmacyMapper.mapMedicinePharmacyToMedicinePharmacyDto(mp);
            meds.add(mpDto);
        }
        prescriptionDto.setMedicines(meds);
        return prescriptionDto;
    }
}
