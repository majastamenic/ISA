package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.users.controller.dto.PatientDto;

public class CounselingDto {
    private long id;
    private String email;
    private String patientEmail;
    private PatientDto patientDto;
    private Schedule schedule;
    private Report report;
    private boolean patientCame;

    public CounselingDto(){}

    public CounselingDto(long id, String email, String patientEmail, PatientDto patientDto, Schedule schedule,
                         Report report, boolean patientCame) {
        this.id = id;
        this.email = email;
        this.patientEmail = patientEmail;
        this.patientDto = patientDto;
        this.schedule = schedule;
        this.report = report;
        this.patientCame = patientCame;
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
}
