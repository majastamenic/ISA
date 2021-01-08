package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Pharmacy implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO: Ime i apikey jedinstveni?
    @Column
    private String name;
    @OneToMany
    private List<Hospital> hospitals;
    @Column
    private String apiKey;
    @Column
    private String address;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicinePharmacy> medicinePharmaciest;

    public Pharmacy() {
    }

    public Pharmacy(Long id, String name, List<Hospital> hospitals, String apiKey, String address,
                    List<MedicinePharmacy> medicinePharmaciest) {
        super();
        this.id = id;
        this.name = name;
        this.hospitals = hospitals;
        this.apiKey = apiKey;
        this.address = address;
        this.medicinePharmaciest = medicinePharmaciest;
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

    public List<MedicinePharmacy> getMedicinePharmaciest() {
        return medicinePharmaciest;
    }

    public void setMedicinePharmaciest(List<MedicinePharmacy> medicinePharmaciest) {
        this.medicinePharmaciest = medicinePharmaciest;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospital(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MedicinePharmacy> getMedicinePharmacies() {
        return medicinePharmaciest;
    }

    public void setMedicinePharmacies(List<MedicinePharmacy> medicinePharmacies) {
        this.medicinePharmaciest = medicinePharmacies;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result + ((hospitals == null) ? 0 : hospitals.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((medicinePharmaciest == null) ? 0 : medicinePharmaciest.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return name;
    }


}
