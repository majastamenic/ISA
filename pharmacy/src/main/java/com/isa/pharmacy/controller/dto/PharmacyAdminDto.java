package com.isa.pharmacy.controller.dto;

public class PharmacyAdminDto {
    private RegistrationDto registrationDto;
    private PharmacyDto pharmacyDto;

    public PharmacyAdminDto(){}

    public PharmacyAdminDto(RegistrationDto registrationDto, PharmacyDto pharmacyDto) {
        this.registrationDto = registrationDto;
        this.pharmacyDto = pharmacyDto;
    }

    public RegistrationDto getRegistrationDto() {
        return registrationDto;
    }

    public void setRegistrationDto(RegistrationDto registrationDto) {
        this.registrationDto = registrationDto;
    }

    public PharmacyDto getPharmacyDto() {
        return pharmacyDto;
    }

    public void setPharmacyDto(PharmacyDto pharmacyDto) {
        this.pharmacyDto = pharmacyDto;
    }
}
