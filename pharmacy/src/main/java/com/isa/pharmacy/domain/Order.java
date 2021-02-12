package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.users.domain.PharmacyAdmin;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "app_order")
@Table
public class Order implements Serializable {
    private static final long serialVersionUID = -2552181062633782965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<OrderOffer> orderOffers;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+01:00")
    private Date endTime;
    @ManyToOne
    private PharmacyAdmin pharmacyAdmin;

    public Order() {
    }

    public Order(Long id, List<OrderOffer> orderOffers, Date endDate, Date endTime, PharmacyAdmin pharmacyAdmin) {
        this.id = id;
        this.orderOffers = orderOffers;
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

    public List<OrderOffer> getOrderOffers() {
        return orderOffers;
    }

    public void setOrderOffers(List<OrderOffer> orderOffers) {
        this.orderOffers = orderOffers;
    }

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }
}
