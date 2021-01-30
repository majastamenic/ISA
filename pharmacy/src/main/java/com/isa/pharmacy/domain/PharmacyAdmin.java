package com.isa.pharmacy.domain;

import javax.persistence.*;

@Entity
@Table
public class PharmacyAdmin extends User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PharmacyAdmin(Long id) {
        this.id = id;
    }

    public PharmacyAdmin(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, Long id1) {
        super(id, email, password, name, surname, address, city, country, phone);
        this.id = id1;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
