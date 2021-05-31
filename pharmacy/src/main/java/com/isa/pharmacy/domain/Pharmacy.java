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
    @Column
    private Double latitude;
    @Column
    private Double longitude;

    public Pharmacy() { }

    public Pharmacy(Long id, String name, String address, Double latitude, Double longitude,Integer counselingPrice, List<MedicinePharmacy> medicinePharmacy, List<String> subscribedEmails) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.counselingPrice = counselingPrice;
        this.medicinePharmacy = medicinePharmacy;
        this.subscribedEmails = subscribedEmails;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
