package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Prescription implements Serializable {
    private static final long serialVersionUID = 6680695108133719052L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer days;
    @ManyToMany
    private List<Diagnosis> diagnosis;
    @ManyToMany
    private List<MedicinePharmacy> medicines;

    public Prescription(){}


    public Prescription(Long id, Integer days, List<Diagnosis> diagnosis, List<MedicinePharmacy> medicines) {
        this.id = id;
        this.days = days;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
    }

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public List<MedicinePharmacy> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicinePharmacy> medicines) {
        this.medicines = medicines;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
