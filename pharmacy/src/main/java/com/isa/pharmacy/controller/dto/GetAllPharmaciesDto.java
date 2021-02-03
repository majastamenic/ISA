package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Profile.Pharmacist;

import java.util.List;

public class GetAllPharmaciesDto {

    private Long id;
    private String name;
    private String address;
    private List<Pharmacist> pharmacists;
    private List<GetAllPharmaciesPharmacyAdminDto> admins;

    public GetAllPharmaciesDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    public void setPharmacists(List<Pharmacist> pharmacists) {
        this.pharmacists = pharmacists;
    }

    public List<GetAllPharmaciesPharmacyAdminDto> getAdmins() {
        return admins;
    }

    public void setAdmins(List<GetAllPharmaciesPharmacyAdminDto> admins) {
        this.admins = admins;
    }
}
