package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.OrderOffer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<OrderOffer> offers;
    @Column
    private String email;

    public Supplier() {}

    public Supplier(Long id, User user, List<OrderOffer> offers, String email) {
        this.id = id;
        this.user = user;
        this.offers = offers;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<OrderOffer> offers) {
        this.offers = offers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
