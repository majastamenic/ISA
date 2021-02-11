package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.users.controller.dto.PatientDto;

public class CounselingDto {
    private long id;
    private String email;
    private String patientEmail;
    private PatientDto patientDto;
    private Schedule schedule;
    private ReportDto report;
    private Boolean patientCame;
    private int loyaltyPoints;

    public CounselingDto(){}

    public CounselingDto(long id, String email, String patientEmail, PatientDto patientDto, Schedule schedule, ReportDto report, Boolean patientCame, int loyaltyPoints) {
        this.id = id;
        this.email = email;
        this.patientEmail = patientEmail;
        this.patientDto = patientDto;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
        this.loyaltyPoints = loyaltyPoints;
    }

    public ReportDto getReport() {
        return report;
    }

    public void setReport(ReportDto report) {
        this.report = report;
    }

    public Boolean getPatientCame() {
        return patientCame;
    }

    public void setPatientCame(Boolean patientCame) {
        this.patientCame = patientCame;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
