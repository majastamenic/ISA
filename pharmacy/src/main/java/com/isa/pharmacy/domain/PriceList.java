package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class PriceList {
    private static final long serialVersionUID = 8492848936253590889L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MedicinePharmacy medicinePharmacy;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dateFrom;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dateTo;
    @Column
    private Integer price;

    public PriceList(){ }

    public PriceList(Long id, Date dateFrom, Date dateTo, Integer price, MedicinePharmacy medicinePharmacy) {
        this.id=id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.medicinePharmacy= medicinePharmacy;
    }
    public PriceList(Date dateFrom, Date dateTo, Integer price, MedicinePharmacy medicinePharmacy) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.medicinePharmacy= medicinePharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public MedicinePharmacy getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(MedicinePharmacy medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }
}
