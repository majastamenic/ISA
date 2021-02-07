package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.dto.UserDto;

public class ExaminationDto {
    private Long id;
    private UserDto dermatologist;
    private PatientDto patient;
    private PharmacyDto pharmacy;
    private Integer price;
    private WorkScheduleDto schedule;

    public ExaminationDto(Long id, UserDto dermatologist, PatientDto patient, PharmacyDto pharmacy, Integer price, WorkScheduleDto schedule) {
        this.id = id;
        this.dermatologist = dermatologist;
        this.patient = patient;
        this.pharmacy = pharmacy;
        this.price = price;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(UserDto dermatologist) {
        this.dermatologist = dermatologist;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public PharmacyDto getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyDto pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public WorkScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkScheduleDto schedule) {
        this.schedule = schedule;
    }
}
