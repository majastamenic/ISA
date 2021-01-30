package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Medicine implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long code;
    @Column
    private String name;
    @Column
    private String typeOfMedicine;
    @Column
    private String formOfMedicine;
    @ElementCollection
    private List<String> composition;
    @Column
    private String manufactured;
    @Column    //TODO: staviti enum
    private String publishingType;
    @ElementCollection
    private List<String> replacementMedicines;
    @Column
    private String note;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicinePharmacy> medicinePharmacy;
    @OneToMany
    private List<Order> order;

    public Medicine() {
    }

    public Medicine(Long id, Long code, String name, String typeOfMedicine, String formOfMedicine,
                    List<String> composition, String manufactured, String publishingType,
                    List<String> replacementMedicines, String note, List<MedicinePharmacy> medicinePharmacy, List<Order> order) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.typeOfMedicine = typeOfMedicine;
        this.formOfMedicine = formOfMedicine;
        this.composition = composition;
        this.manufactured = manufactured;
        this.publishingType = publishingType;
        this.replacementMedicines = replacementMedicines;
        this.note = note;
        this.medicinePharmacy = medicinePharmacy;
        this.order=order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfMedicine() {
        return typeOfMedicine;
    }

    public void setTypeOfMedicine(String typeOfMedicine) {
        this.typeOfMedicine = typeOfMedicine;
    }

    public String getFormOfMedicine() {
        return formOfMedicine;
    }

    public void setFormOfMedicine(String formOfMedicine) {
        this.formOfMedicine = formOfMedicine;
    }

    public List<String> getComposition() {
        return composition;
    }

    public void setComposition(List<String> composition) {
        this.composition = composition;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public String getPublishingType() {
        return publishingType;
    }

    public void setPublishingType(String publishingType) {
        this.publishingType = publishingType;
    }

    public List<String> getReplacementMedicine() {
        return replacementMedicines;
    }

    public void setReplacementMedicine(List<String> replacementMedicines) {
        this.replacementMedicines = replacementMedicines;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<MedicinePharmacy> getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(List<MedicinePharmacy> medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
