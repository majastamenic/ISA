package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.users.controller.dto.PatientDto;

import java.util.Date;
import java.util.List;

public class EPrescriptionDto {
    private Long code;
    private PatientDto patient;
    private Date dateOfIssue;
    private List<MedicineEPrescriptionDto> listOfMedication;
    private List<PharmacyPriceDto> pharmacyPriceDtoList;

    public EPrescriptionDto(){}

    public EPrescriptionDto(Long code, PatientDto patient, Date dateOfIssue, List<MedicineEPrescriptionDto> listOfMedication, List<PharmacyPriceDto> pharmacyPriceDtoList) {
        this.code = code;
        this.patient = patient;
        this.dateOfIssue = dateOfIssue;
        this.listOfMedication = listOfMedication;
        this.pharmacyPriceDtoList = pharmacyPriceDtoList;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public List<MedicineEPrescriptionDto> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(List<MedicineEPrescriptionDto> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    public List<PharmacyPriceDto> getPharmacyPriceDtoList() {
        return pharmacyPriceDtoList;
    }

    public void setPharmacyPriceDtoList(List<PharmacyPriceDto> pharmacyPriceDtoList) {
        this.pharmacyPriceDtoList = pharmacyPriceDtoList;
    }
}
