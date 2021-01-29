package com.isa.pharmacy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Order {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Medicine> medicineList;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Column
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date endTime;
    @Column
    private PharmacyAdmin pharmacyAdmin;

    public Order(Long id, List<Medicine> medicineList, Date endDate, Date endTime, PharmacyAdmin pharmacyAdmin) {
        this.id = id;
        this.medicineList = medicineList;
        this.endDate = endDate;
        this.endTime = endTime;
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
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

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }
}
