package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column
    private Schedule schedule;
    @Column
    private Integer price;
    @ElementCollection
    private List<Diagnosis> diagnosis;

    public Examination(){}

    public Examination(Long id, Dermatologist dermatologist, Patient patient, Date startDate, Date endDate, Prescription prescription, Schedule schedule, Integer price,List<Diagnosis> diagnosis) {
        this.id = id;
        this.dermatologist = dermatologist;
        this.patient = patient;
        this.prescription = prescription;
        this.schedule = schedule;
        this.price=price;
        this.diagnosis = diagnosis;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
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
