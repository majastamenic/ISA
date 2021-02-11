package com.isa.pharmacy.controller.mapping;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.isa.pharmacy.controller.dto.EPrescriptionDto;
import com.isa.pharmacy.controller.dto.MedicineEPrescriptionDto;
import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.MedicineEPrescription;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;

public class EPrescriptionMapper {

    public static EPrescription mapStringToEPrescription(String text) {
        EPrescription ePrescription = new EPrescription();
        String[] parts = text.split("\\r?\\n");
        String[] textParts = parts[1].split(":");
        String textObj = textParts[1];
        textObj = textObj.substring(2, textObj.length() - 1);

        String[] splitText = textObj.split(" ");

        String note = splitText[0] + " " + splitText[1] + "\n" + splitText[2] + "\n" + splitText[3] + "\n" + splitText[4] + "\n" + splitText[5];

        ePrescription.setFileText(note);
//        ePrescription.setPatient(splitText[0] + " " + splitText[1]);
        ePrescription.setCode(Long.parseLong(splitText[2]));
        ePrescription.setDateOfIssue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        List<MedicineEPrescription> listMedicine = new ArrayList<>();
        MedicineEPrescription medicineEPrescription = new MedicineEPrescription();
        medicineEPrescription.setCode(new Random().nextLong());
        medicineEPrescription.setName(splitText[4]);
        medicineEPrescription.setQuantity(Integer.parseInt(splitText[5]));

        listMedicine.add(medicineEPrescription);

        ePrescription.setListOfMedication(listMedicine);

        return ePrescription;
    }

    public static EPrescriptionDto mapEPrescriptionToEPrescriptionDto(EPrescription ePrescription, List<PharmacyPriceDto> pharmacyPriceDtos){
        EPrescriptionDto ePrescriptionDto = new EPrescriptionDto();
        ePrescriptionDto.setCode(ePrescription.getCode());
        ePrescriptionDto.setDateOfIssue(ePrescription.getDateOfIssue());
        ePrescriptionDto.setListOfMedication(mapMedicineEPrescriptionToDto(ePrescription.getListOfMedication()));
        ePrescriptionDto.setPatient(PatientMapper.mapPatientToPatientDto(ePrescription.getPatient()));
        ePrescriptionDto.setPharmacyPriceDtoList(pharmacyPriceDtos);
        return ePrescriptionDto;
    }

    public static List<MedicineEPrescriptionDto> mapMedicineEPrescriptionToDto(List<MedicineEPrescription> medicineEPrescriptions){
        List<MedicineEPrescriptionDto> medicineEPrescriptionDtos = new ArrayList<>();
        for(MedicineEPrescription medicineEPrescription: medicineEPrescriptions){
            MedicineEPrescriptionDto medicineEPrescriptionDto = new MedicineEPrescriptionDto();
            medicineEPrescriptionDto.setMedicineName(medicineEPrescription.getName());
            medicineEPrescriptionDto.setQuantity(medicineEPrescription.getQuantity());
            medicineEPrescriptionDtos.add(medicineEPrescriptionDto);
        }
        return medicineEPrescriptionDtos;
    }

    public static EPrescriptionDto mapEPrescriptionToEPrescriptionDto(EPrescription ePrescription){
        EPrescriptionDto ePrescriptionDto = new EPrescriptionDto();
        ePrescriptionDto.setCode(ePrescription.getCode());
        ePrescriptionDto.setDateOfIssue(ePrescription.getDateOfIssue());
        ePrescriptionDto.setListOfMedication(mapMedicineEPrescriptionToDto(ePrescription.getListOfMedication()));
        ePrescriptionDto.setPatient(PatientMapper.mapPatientToPatientDto(ePrescription.getPatient()));
        return ePrescriptionDto;
    }

    public static List<EPrescriptionDto> mapListEPrescriptionToEPrescriptionDto(List<EPrescription> ePrescriptions){
        List<EPrescriptionDto> mappedPrescriptions = new ArrayList<>();
        for(EPrescription ePrescription : ePrescriptions)
            mappedPrescriptions.add(mapEPrescriptionToEPrescriptionDto(ePrescription));
        return mappedPrescriptions;
    }
}
