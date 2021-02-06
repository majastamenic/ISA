package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Schedule;


public class ExamDermatologistDto {
    private Long id;
    private String email;
    private String patientEmail;
    private PatientDto patientDto;
    private Schedule schedule;
    private PrescriptionDto prescription;
    private String pharmacyName;
    private Integer price;
    private Boolean patientCame;

    public ExamDermatologistDto(){}

    public ExamDermatologistDto(Long id, String email, String patientEmail, PatientDto patientDto, Schedule schedule, PrescriptionDto prescription, String pharmacyName, Integer price, Boolean patientCame) {
        this.id = id;
        this.email = email;
        this.patientEmail = patientEmail;
        this.patientDto = patientDto;
        this.schedule = schedule;
        this.prescription = prescription;
        this.pharmacyName = pharmacyName;
        this.price = price;
        this.patientCame = patientCame;
    }

    public Boolean getPatientCame() {
        return patientCame;
    }

    public void setPatientCame(Boolean patientCame) {
        this.patientCame = patientCame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public PrescriptionDto getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDto prescription) {
        this.prescription = prescription;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
