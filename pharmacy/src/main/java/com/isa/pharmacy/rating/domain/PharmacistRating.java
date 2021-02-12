package com.isa.pharmacy.rating.domain;

import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class PharmacistRating implements Serializable {
    private static final long serialVersionUID = 1217786776279636013L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rate;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Pharmacist pharmacist;

    public PharmacistRating(){}

    public PharmacistRating(Long id, Integer rate, Patient patient, Pharmacist pharmacist) {
        this.id = id;
        this.rate = rate;
        this.patient = patient;
        this.pharmacist = pharmacist;
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

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }
}
