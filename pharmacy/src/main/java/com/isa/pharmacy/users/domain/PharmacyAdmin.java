package com.isa.pharmacy.users.domain;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.Pharmacy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PharmacyAdmin implements Serializable {
    private static final long serialVersionUID = 6265056492526032848L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany          // TODO: Bidirekciona veza? Obrisati?
    private List<Order> orders;
    @OneToOne
    private Pharmacy pharmacy;

    public PharmacyAdmin(){}

    public PharmacyAdmin(Long id, User user, List<Order> orders, Pharmacy pharmacy) {
        this.user =user;
        this.id = id;
        this.orders= orders;
        this.pharmacy = pharmacy;
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
}
