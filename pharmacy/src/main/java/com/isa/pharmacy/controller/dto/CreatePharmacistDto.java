package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Profile.User;
import java.util.List;

public class CreatePharmacistDto {

    private Long id;
    private User user;
    private boolean isFirstLog = true;
    private Long pharmacyId;
    private List<Long> workScheduleIds;

    public CreatePharmacistDto() { }

    public CreatePharmacistDto(Long id, User user, boolean isFirstLog, Long pharmacyId, List<Long> workScheduleIds) {
        this.id = id;
        this.user = user;
        this.isFirstLog = isFirstLog;
        this.pharmacyId = pharmacyId;
        this.workScheduleIds = workScheduleIds;
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

    public boolean isFirstLog() {
        return isFirstLog;
    }

    public void setFirstLog(boolean firstLog) {
        isFirstLog = firstLog;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public List<Long> getWorkScheduleIds() {
        return workScheduleIds;
    }

    public void setWorkScheduleIds(List<Long> workScheduleIds) {
        this.workScheduleIds = workScheduleIds;
    }
}
