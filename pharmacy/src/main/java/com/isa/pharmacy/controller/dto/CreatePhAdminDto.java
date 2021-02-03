package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Profile.User;

public class CreatePhAdminDto {
    private User user;
    private Long pharmacyId;

    public CreatePhAdminDto(){}

    public CreatePhAdminDto(User user, Long pharmacyId) {
        this.user = user;
        this.pharmacyId = pharmacyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
