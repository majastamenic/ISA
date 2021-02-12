package com.isa.pharmacy.rating.domain;

import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class DermatologistRating implements Serializable {
    private static final long serialVersionUID = 8713458366290368099L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rate;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Dermatologist dermatologist;

    public DermatologistRating(){}

    public DermatologistRating(Long id, Integer rate, Patient patient, Dermatologist dermatologist) {
        this.id = id;
        this.rate = rate;
        this.patient = patient;
        this.dermatologist = dermatologist;
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

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
