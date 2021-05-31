package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.List;

public class GetAllPharmaciesDto {

    private Long id;
    private String name;
    private String address;
    private List<Pharmacist> pharmacists;
    private List<GetAllPharmaciesPharmacyAdminDto> admins;
    private Double latitude;
    private Double longitude;

    public GetAllPharmaciesDto() { }

    public GetAllPharmaciesDto(Long id, String name,Double latitude, Double longitude, String address, List<Pharmacist> pharmacists, List<GetAllPharmaciesPharmacyAdminDto> admins) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pharmacists = pharmacists;
        this.admins = admins;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
