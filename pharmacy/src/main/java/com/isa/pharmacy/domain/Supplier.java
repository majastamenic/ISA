package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Supplier {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<OrderOffer> offers;
    @Column
    private String email;

    public Supplier() {
    }

    public Supplier(Long id, List<OrderOffer> offers, String email) {
        this.id = id;
        this.offers = offers;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
