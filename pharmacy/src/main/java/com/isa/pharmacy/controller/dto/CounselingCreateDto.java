package com.isa.pharmacy.controller.dto;

public class CounselingCreateDto {
    private long id;
    private String pharmacistEmail;
    private String patientEmail;
    private WorkScheduleDto schedule;
    private Integer loyaltyPoints;

    public CounselingCreateDto(){}

    public CounselingCreateDto(long id, String pharmacistEmail, String patientEmail,
                               WorkScheduleDto schedule, Integer loyaltyPoints) {
        this.id = id;
        this.pharmacistEmail = pharmacistEmail;
        this.patientEmail = patientEmail;
        this.schedule = schedule;
        this.loyaltyPoints = loyaltyPoints;
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

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
