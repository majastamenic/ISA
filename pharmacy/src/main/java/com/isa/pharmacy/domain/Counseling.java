package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.users.Patient;
import com.isa.pharmacy.domain.users.Pharmacist;
import com.isa.pharmacy.domain.enums.ExaminationAndCounselingStatus;
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
    @Column
    private ExaminationAndCounselingStatus counselingStatus;

    public Counseling(){}

    public Counseling(Long id, Pharmacist pharmacist, Patient patient, Schedule schedule, Report report, boolean patientCame, ExaminationAndCounselingStatus counselingStatus) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
        this.counselingStatus = counselingStatus;
    }

    public boolean isPatientCame() {
        return patientCame;
    }

    public void setPatientCame(boolean patientCame) {
        this.patientCame = patientCame;
    }

    public ExaminationAndCounselingStatus getCounselingStatus() {
        return counselingStatus;
    }

    public void setCounselingStatus(ExaminationAndCounselingStatus counselingStatus) {
        this.counselingStatus = counselingStatus;
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
