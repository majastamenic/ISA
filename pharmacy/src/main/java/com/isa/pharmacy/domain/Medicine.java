package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Medicine implements Serializable {
    private static final long serialVersionUID = 588135730011427705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long code;
    @Column(nullable = false)
    private String name;
    @Column
    private String typeOfMedicine;
    @Column
    private FormOfMedicine formOfMedicine;
    @Column
    private String composition;
    @Column
    private String manufactured;
    @Column
    private MedicinePublishingType publishingType;
    @ElementCollection
    private List<Long> replacementMedicines;
    @Column
    private String note;
    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicinePharmacy> medicinePharmacy;

    public Medicine() { }

    public Medicine(Long id, Long code, String name, String typeOfMedicine, FormOfMedicine formOfMedicine,
                    String composition, String manufactured, MedicinePublishingType publishingType,
                    List<Long> replacementMedicines, String note, List<MedicinePharmacy> medicinePharmacy) {
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

    public FormOfMedicine getFormOfMedicine() {
        return formOfMedicine;
    }

    public void setFormOfMedicine(FormOfMedicine formOfMedicine) {
        this.formOfMedicine = formOfMedicine;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public MedicinePublishingType getPublishingType() {
        return publishingType;
    }

    public void setPublishingType(MedicinePublishingType publishingType) {
        this.publishingType = publishingType;
    }

    public List<Long> getReplacementMedicines() {
        return replacementMedicines;
    }

    public void setReplacementMedicines(List<Long> replacementMedicines) {
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
}
