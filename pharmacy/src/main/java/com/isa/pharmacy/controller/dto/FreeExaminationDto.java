package com.isa.pharmacy.controller.dto;

public class FreeExaminationDto {
    private UserDto dermatologist;
    private PharmacyDto pharmacy;
    private Integer price;
    private WorkScheduleDto schedule;

    public FreeExaminationDto(){ }

    public FreeExaminationDto(UserDto dermatologist, PharmacyDto pharmacy, Integer price, WorkScheduleDto schedule) {
        this.dermatologist = dermatologist;
        this.pharmacy = pharmacy;
        this.price = price;
        this.schedule = schedule;
    }

    public UserDto getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(UserDto dermatologist) {
        this.dermatologist = dermatologist;
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
