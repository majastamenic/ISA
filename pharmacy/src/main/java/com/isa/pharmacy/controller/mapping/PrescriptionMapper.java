package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.PrescriptionDto;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionMapper {

    public static PrescriptionDto mapPrescriptionToPrescriptionDto(Prescription prescription){
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        if(prescription != null){
            prescriptionDto.setId(prescription.getId());
            prescriptionDto.setDays(prescription.getDays());
        }
        return prescriptionDto;
    }

    public static Prescription mapPrescriptionDtoToPrescription(PrescriptionDto prescriptionDto, Pharmacy pharmacy, Prescription prescriptionSaved){
        Prescription prescription = new Prescription();
        prescription.setId(prescriptionSaved.getId());
        prescription.setDays(prescriptionDto.getDays());
        //prescription.setDiagnoses(prescriptionDto.getDiagnoses());
        List<MedicinePharmacy> meds = new ArrayList<>();
        if(prescriptionDto.getMedicines() != null){
            /*for(MedicinePharmacyDto mpDto : prescriptionDto.getMedicines()){
                MedicinePharmacy mp = MedicinePharmacyMapper.mapMedicinePharmacyDtoToMedicinePharmacy(mpDto, pharmacy);
                meds.add(mp);
            }*/
        }
        prescription.setMedicines(meds);
        return prescription;
    }
}
