package com.isa.pharmacy.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.domain.MedicinePharmacy;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CreatePriceListDto {

    private Long id;
    private MedicinePharmacy medicinePharmacy;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

    public CreatePriceListDto() {
    }

    public CreatePriceListDto(Long id, MedicinePharmacy medicinePharmacy, Date dateFrom, Date dateTo) {
        this.id = id;
        this.medicinePharmacy = medicinePharmacy;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicinePharmacy getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(MedicinePharmacy medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
