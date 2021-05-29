package com.isa.pharmacy.users.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AddDermatologistDto {
    String email;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date startTime;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date endTime;
    String adminEmail;

    public AddDermatologistDto() {
    }

    public AddDermatologistDto(String email, Date startDate, Date endDate, Date startTime, Date endTime, String adminEmail) {
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adminEmail = adminEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
