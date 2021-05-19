package com.isa.pharmacy.users.controller.dto;

import com.isa.pharmacy.users.domain.User;

public class PharmacyAdminDto {
    private User user;
    private String pharmacyName;

    public PharmacyAdminDto() {

    }

    public PharmacyAdminDto(User user, String pharmacyName) {
        this.user = user;
        this.pharmacyName = pharmacyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
