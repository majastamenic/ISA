package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class PharmacySystem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String apiKey;

    @OneToMany
    private List<Pharmacy> pharmacies;

    public PharmacySystem() {
    }

    public PharmacySystem(Long id, String apiKey, List<Pharmacy> pharmacies) {
        this.id = id;
        this.apiKey = apiKey;
        this.pharmacies = pharmacies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }
}
