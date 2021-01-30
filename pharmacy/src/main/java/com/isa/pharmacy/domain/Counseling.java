package com.isa.pharmacy.domain;

import javax.persistence.*;

@Entity
@Table
public class Counseling {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pharmacist pharmacist;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Schedule schedule;
    @Column
    private String note;

    public Counseling(){}

    public Counseling(Long id, Pharmacist pharmacist, Patient patient, Schedule schedule, String note) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
