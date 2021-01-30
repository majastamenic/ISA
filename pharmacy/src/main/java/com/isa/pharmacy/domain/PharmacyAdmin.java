package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PharmacyAdmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String phone;
    @OneToMany
    private List<Order> orders;

    public PharmacyAdmin(){}

    public PharmacyAdmin(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, List<Order> orders) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.orders= orders;
    }

}
