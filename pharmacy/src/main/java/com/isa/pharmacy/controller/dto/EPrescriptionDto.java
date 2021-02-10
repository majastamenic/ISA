package com.isa.pharmacy.controller.dto;

import java.util.Date;
import java.util.List;

public class EPrescriptionDto {
    private Long code;
    private String patientName;
    private Date dateOfIssue;
    private List<MedicineEPrescriptionDto> listOfMedication;
    private List<PharmacyPriceDto> pharmacyPriceDtoList;

    public EPrescriptionDto(){}

    public EPrescriptionDto(Long code, String patientName, Date dateOfIssue, List<MedicineEPrescriptionDto> listOfMedication, List<PharmacyPriceDto> pharmacyPriceDtoList) {
        this.code = code;
        this.patientName = patientName;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
