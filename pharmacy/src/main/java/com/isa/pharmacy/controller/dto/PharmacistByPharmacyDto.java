package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.users.domain.User;

public class PharmacistByPharmacyDto {
    private User user;

    public PharmacistByPharmacyDto() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
