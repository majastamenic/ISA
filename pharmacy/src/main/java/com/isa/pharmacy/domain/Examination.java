package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.users.Dermatologist;
import com.isa.pharmacy.domain.users.Patient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Examination implements Serializable {

    private static final long serialVersionUID = 4298262714187299282L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Dermatologist dermatologist;
    @OneToOne
    private Pharmacy pharmacy;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Prescription prescription;
    @OneToOne
    private Schedule schedule;
    @Column
    private Integer price;
    @OneToMany
    private List<Diagnosis> diagnosis;
    @Column
    private int loyaltyPoints;

    public Examination(){}

    public Examination(Long id, Dermatologist dermatologist, Pharmacy pharmacy, Patient patient, Prescription prescription, Schedule schedule, Integer price, List<Diagnosis> diagnosis, int loyaltyPoints) {
        this.id = id;
        this.dermatologist = dermatologist;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.prescription = prescription;
        this.schedule = schedule;
        this.price = price;
        this.diagnosis = diagnosis;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}