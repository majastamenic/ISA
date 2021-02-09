package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.users.domain.User;

    // TODO: ???? Koristiti klasu UserDto umesto ovoga
public class PharmacistByPharmacyDto {
    private User user;

    public PharmacistByPharmacyDto() {
    }

    public PharmacistByPharmacyDto(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
