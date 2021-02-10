package com.isa.pharmacy.domain;

import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Counseling implements Serializable {
    private static final long serialVersionUID = -3735212154097668426L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pharmacist pharmacist;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Schedule schedule;
    @OneToOne           // TODO: Obrisati ili odavde ili iz Reporta Counseling
    private Report report;
    @Column
    private boolean patientCame;
    @ManyToOne
    private LoyaltyGroup loyaltyGroup;

    public Counseling(){}

    public Counseling(Long id, Pharmacist pharmacist, Patient patient, Schedule schedule,
                      Report report, boolean patientCame, LoyaltyGroup loyaltyGroup) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
        this.loyaltyGroup = loyaltyGroup;
    }

    public Counseling(Long id, Pharmacist pharmacist, Patient patient, Schedule schedule,
                      Report report, boolean patientCame) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public boolean isPatientCame() {
        return patientCame;
    }

    public void setPatientCame(boolean patientCame) {
        this.patientCame = patientCame;
    }

    public LoyaltyGroup getLoyaltyGroup() {
        return loyaltyGroup;
    }

    public void setLoyaltyGroup(LoyaltyGroup loyaltyGroup) {
        this.loyaltyGroup = loyaltyGroup;
    }
}
