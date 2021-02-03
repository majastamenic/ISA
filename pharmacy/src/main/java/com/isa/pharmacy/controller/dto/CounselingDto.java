package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.domain.Schedule;
import com.isa.pharmacy.domain.enums.ExaminationAndCounselingStatus;

public class CounselingDto {
    private String email;
    private Patient patient;
    private Schedule schedule;
    private Report report;
    private boolean patientCame;
    private ExaminationAndCounselingStatus counselingStatus;

    public CounselingDto(){}

    public CounselingDto(String email, Patient patient, Schedule schedule, Report report, boolean patientCame, ExaminationAndCounselingStatus counselingStatus) {
        this.email = email;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
        this.counselingStatus = counselingStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ExaminationAndCounselingStatus getCounselingStatus() {
        return counselingStatus;
    }

    public void setCounselingStatus(ExaminationAndCounselingStatus counselingStatus) {
        this.counselingStatus = counselingStatus;
    }
}
