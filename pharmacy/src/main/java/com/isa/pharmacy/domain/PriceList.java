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
    @Column                         // TODO Tasa: Mozda bolje da medicinePharmacy ima Pricelist
    private MedicinePharmacy medicinePharmacy;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dateFrom;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dateTo;

    public PriceList(){ }

    public PriceList(Long id, MedicinePharmacy medicinePharmacy, Date dateFrom, Date dateTo) {
        this.id=id;
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
