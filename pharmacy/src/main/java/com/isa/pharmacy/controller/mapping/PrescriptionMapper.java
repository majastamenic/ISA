package com.isa.pharmacy.controller.mapping;

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

    public static Prescription mapPrescriptionDtoToPrescription(PrescriptionDto prescriptionDto, Prescription prescriptionSaved){
        Prescription prescription = new Prescription();
        prescription.setId(prescriptionSaved.getId());
        prescription.setDays(prescriptionDto.getDays());
        return prescription;
    }
}
