package com.isa.pharmacy.controller.dto;

import java.util.Date;

public class CounselingCreateDto {
    private long id;
    private String pharmacistEmail;
    private String patientEmail;
    private WorkScheduleDto schedule;

    public CounselingCreateDto(){}

    public CounselingCreateDto(long id, String pharmacistEmail, String patientEmail,
                               WorkScheduleDto schedule) {
        this.id = id;
        this.pharmacistEmail = pharmacistEmail;
        this.patientEmail = patientEmail;
        this.schedule = schedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPharmacistEmail() {
        return pharmacistEmail;
    }

    public void setPharmacistEmail(String pharmacistEmail) {
        this.pharmacistEmail = pharmacistEmail;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public WorkScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkScheduleDto schedule) {
        this.schedule = schedule;
    }

    public void serScheduleEndTime(Date endTime){
        this.schedule.setEndTime(endTime);
    }
}
