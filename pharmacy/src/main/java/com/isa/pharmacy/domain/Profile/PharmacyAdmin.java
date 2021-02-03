package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PharmacyAdmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Order> orders;
    @OneToOne
    private Pharmacy pharmacy;
    @OneToMany
    private List<WorkSchedule> schedule;
    @Column
    private Boolean isFirstLog;

    public PharmacyAdmin(){}

    public PharmacyAdmin(Long id, User user, List<Order> orders, Pharmacy pharmacy,List<WorkSchedule> schedule, Boolean isFirstLog) {
        this.user =user;
        this.id = id;
        this.orders= orders;
        this.pharmacy = pharmacy;
        this.schedule = schedule;
        this.isFirstLog = isFirstLog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFirstLog() {
        return isFirstLog;
    }

    public void setFirstLog(Boolean firstLog) {
        isFirstLog = firstLog;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<WorkSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<WorkSchedule> schedule) {
        this.schedule = schedule;
    }
}
