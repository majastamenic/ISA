package com.isa.pharmacy.domain;

import javax.persistence.Entity;

@Entity
public class PharmacyAdmin extends User{
    private static final long serialVersionUID = 1L;

    public PharmacyAdmin(){}

    public PharmacyAdmin(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone) {
        super(id, email, password, name, surname, address, city, country, phone);
    }


}
