package com.isa.pharmacy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class PriceList {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private MedicinePharmacy medicinePharmacy;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

    public PriceList(MedicinePharmacy medicinePharmacy, Date dateFrom, Date dateTo) {
        this.medicinePharmacy = medicinePharmacy;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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
