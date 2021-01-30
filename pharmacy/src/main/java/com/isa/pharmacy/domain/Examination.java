package com.isa.pharmacy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Examination {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Dermatologist dermatologist;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Prescription prescription;
    @OneToOne
    private Schedule schedule;
    @Column
    private Integer price;

    public Examination(){}

    public Examination(Long id, Dermatologist dermatologist, Patient patient, Prescription prescription, Schedule schedule, Integer price) {
        this.id = id;
        this.dermatologist = dermatologist;
        this.patient = patient;
        this.prescription = prescription;
        this.schedule = schedule;
        this.price=price;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
