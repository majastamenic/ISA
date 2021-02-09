package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.domain.Schedule;
import com.isa.pharmacy.domain.enums.ExaminationAndCounselingStatus;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.dto.PharmacistDto;

public class CounselingFullDto {
    private long id;
    private PharmacistDto pharmacist;
    private PatientDto patient;
    private WorkScheduleDto schedule;
    private Report report;
    private boolean patientCame;
    private ExaminationAndCounselingStatus counselingStatus;
    private Integer loyaltyPoints;

    public CounselingFullDto(long id, PharmacistDto pharmacist, PatientDto patient, WorkScheduleDto schedule,
                             Report report, boolean patientCame, ExaminationAndCounselingStatus counselingStatus,
                             Integer loyaltyPoints) {
        this.id = id;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
        this.counselingStatus = counselingStatus;
        this.loyaltyPoints = loyaltyPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PharmacistDto getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(PharmacistDto pharmacist) {
        this.pharmacist = pharmacist;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public WorkScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkScheduleDto schedule) {
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

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
