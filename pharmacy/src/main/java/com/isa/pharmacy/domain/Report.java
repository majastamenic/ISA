package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Report implements Serializable {
    private static final long serialVersionUID = -3931177016160172335L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String note;
    @OneToMany
    private List<MedicinePharmacy> medicines;
    @Column
    private Integer days;

    public Report(){}

    public Report(Long id, String note, List<MedicinePharmacy> medicines, Integer days) {
        this.id = id;
        this.note = note;
        this.medicines = medicines;
        this.days = days;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
