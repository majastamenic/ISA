package com.isa.pharmacy.controller.dto;

public class WorkSchedulePharmacyDto {
    private WorkScheduleDto workScheduleDto;
    private String pharmacyName;

    public WorkSchedulePharmacyDto(){};

    public WorkSchedulePharmacyDto(WorkScheduleDto workScheduleDto, String pharmacyName) {
        this.workScheduleDto = workScheduleDto;
        this.pharmacyName = pharmacyName;
    }

    public WorkScheduleDto getWorkScheduleDto() {
        return workScheduleDto;
    }

    public void setWorkScheduleDto(WorkScheduleDto workScheduleDto) {
        this.workScheduleDto = workScheduleDto;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
