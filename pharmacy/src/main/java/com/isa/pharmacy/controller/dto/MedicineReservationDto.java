package com.isa.pharmacy.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class MedicineReservationDto {
    private Long id;
    private String patientEmail;
    private String pharmacyName;
    private String medicineName;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dueDate;
    private Integer amount;

    public MedicineReservationDto() {};

    public MedicineReservationDto(Long id, String patientEmail, String pharmacyName,
                                  String medicineName, Date dueDate, Integer amount) {
        this.id = id;
        this.patientEmail = patientEmail;
        this.pharmacyName = pharmacyName;
        this.medicineName = medicineName;
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
