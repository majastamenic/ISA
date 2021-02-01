package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "app_order")
@Table
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Medicine> medicineList;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date endTime;
    @OneToOne
    private PharmacyAdmin pharmacyAdmin;
    @OneToMany
    private List<OrderOffer> offers;

    public Order() {
    }

    public Order(Long id, List<Medicine> medicineList, Date endDate, Date endTime, PharmacyAdmin pharmacyAdmin, List<OrderOffer> offers) {
        this.id = id;
        this.medicineList = medicineList;
        this.endDate = endDate;
        this.endTime = endTime;
        this.pharmacyAdmin=pharmacyAdmin;
        this.offers= offers;
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

    public List<OrderOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<OrderOffer> offers) {
        this.offers = offers;
    }
}
