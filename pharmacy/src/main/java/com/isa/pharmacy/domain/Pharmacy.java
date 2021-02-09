package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Pharmacy implements Serializable {
    private static final long serialVersionUID = 3863418683331588166L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String address;
    @Column
    private Integer counselingPrice;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicinePharmacy> medicinePharmacy;
    @ElementCollection
    private List<String> subscribedEmails;

    public Pharmacy() { }

    public Pharmacy(Long id, String name, String address, Integer counselingPrice, List<MedicinePharmacy> medicinePharmacy, List<String> subscribedEmails) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.counselingPrice = counselingPrice;
        this.medicinePharmacy = medicinePharmacy;
        this.subscribedEmails = subscribedEmails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCounselingPrice() {
        return counselingPrice;
    }

    public void setCounselingPrice(Integer counselingPrice) {
        this.counselingPrice = counselingPrice;
    }

    public List<String> getSubscribedEmails() {
        return subscribedEmails;
    }

    public void setSubscribedEmails(List<String> subscribedEmails) {
        this.subscribedEmails = subscribedEmails;
    }

    public List<MedicinePharmacy> getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(List<MedicinePharmacy> medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return name;
    }
}
