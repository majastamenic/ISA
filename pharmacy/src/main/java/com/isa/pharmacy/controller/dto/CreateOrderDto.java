package com.isa.pharmacy.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//TODO: Obrisati

public class CreateOrderDto {

    private Long id;
    private List<Long> medicinePharmacyIds;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date endTime;
    private Long pharmacyAdminId;

    public CreateOrderDto() {
    }

    public CreateOrderDto(Long id, List<Long> medicinePharmacyIds, Date endDate, Date endTime, Long pharmacyAdminId) {
        this.id = id;
        this.medicinePharmacyIds = medicinePharmacyIds;
        this.endDate = endDate;
        this.endTime = endTime;
        this.pharmacyAdminId = pharmacyAdminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getMedicinePharmacyIds() {
        return medicinePharmacyIds;
    }

    public void setMedicinePharmacyIds(List<Long> medicinePharmacyIds) {
        this.medicinePharmacyIds = medicinePharmacyIds;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getPharmacyAdminId() {
        return pharmacyAdminId;
    }

    public void setPharmacyAdminId(Long pharmacyAdminId) {
        this.pharmacyAdminId = pharmacyAdminId;
    }
}
