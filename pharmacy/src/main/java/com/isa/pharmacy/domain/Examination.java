package com.isa.pharmacy.domain;

import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;

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
    @Column
    private Boolean patientCame;
    @ManyToOne
    private LoyaltyGroup loyaltyGroup;

    public Examination(){}

    public Examination(Long id, Dermatologist dermatologist, Pharmacy pharmacy, Patient patient,
                       Prescription prescription, Schedule schedule, Integer price, Boolean patientCame,
                       List<Diagnosis> diagnosis, LoyaltyGroup loyaltyGroup) {
        this.id = id;
        this.dermatologist = dermatologist;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.prescription = prescription;
        this.schedule = schedule;
        this.price = price;
        this.patientCame = patientCame;
        this.loyaltyGroup = loyaltyGroup;
    }

    public Examination(Dermatologist dermatologist, Pharmacy pharmacy, Schedule schedule, Integer price, LoyaltyGroup loyaltyGroup) {
        this.dermatologist = dermatologist;
        this.pharmacy = pharmacy;
        this.schedule = schedule;
        this.price = price;
        this.loyaltyGroup = loyaltyGroup;
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

    public Boolean getPatientCame() {
        return patientCame;
    }

    public void setPatientCame(Boolean patientCame) {
        this.patientCame = patientCame;
    }

    public LoyaltyGroup getLoyaltyGroup() {
        return loyaltyGroup;
    }

    public void setLoyaltyGroup(LoyaltyGroup loyaltyGroup) {
        this.loyaltyGroup = loyaltyGroup;
    }
}