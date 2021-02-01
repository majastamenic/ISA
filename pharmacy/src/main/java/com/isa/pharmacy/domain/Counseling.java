package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Profile.Pharmacist;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Counseling implements Serializable {
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
    @OneToOne
    private Report report;
    @Column
    private boolean isDone;

    public Counseling(){}

    public Counseling(Long id, Pharmacist pharmacist, Patient patient, Schedule schedule, Report report, boolean isDone) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.isDone = isDone;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
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
