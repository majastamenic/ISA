package com.isa.pharmacy.rating.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class PharmacyRating implements Serializable {
    private static final long serialVersionUID = 6300125663637553826L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rate;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Pharmacy pharmacy;

    public PharmacyRating(){}

    public PharmacyRating(Long id, Integer rate, Patient patient, Pharmacy pharmacy) {
        this.id = id;
        this.rate = rate;
        this.patient = patient;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
