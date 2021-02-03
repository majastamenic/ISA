package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.domain.WorkSchedule;

import java.util.List;

public class GetAllPharmaciesPharmacyAdminDto {
    private Long id;
    private User user;
    private List<WorkSchedule> schedule;
    private Boolean isFirstLog;

    public GetAllPharmaciesPharmacyAdminDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WorkSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<WorkSchedule> schedule) {
        this.schedule = schedule;
    }

    public Boolean getFirstLog() {
        return isFirstLog;
    }

    public void setFirstLog(Boolean firstLog) {
        isFirstLog = firstLog;
    }
}
