package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @Column
    private String name;
    @Column
    private String address;
    @OneToMany
    private List<MedicinePharmacy> medicinePharmaciest;

    public Pharmacy() {
    }

    public Pharmacy(Long id, String name, String address,
                    List<MedicinePharmacy> medicinePharmaciest) {
        super();
        this.id = id;
        this.name = name;
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
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((medicinePharmaciest == null) ? 0 : medicinePharmaciest.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return name;
    }


}
