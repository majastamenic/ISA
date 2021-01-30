package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class PharmacyAdmin extends User{
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
        super(id, email, password, name, surname, address, city, country, phone);
        this.orders=orders;
    }

}
