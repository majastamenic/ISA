package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Report {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String note;
    @OneToOne
    private Counseling counseling;
    @ElementCollection
    private List<MedicinePharmacy> medicines;

    public  Report(){}

    public Report(Long id, String note, Counseling counseling, List<MedicinePharmacy> medicines) {
        this.id = id;
        this.note = note;
        this.counseling = counseling;
        this.medicines = medicines;
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

    public Counseling getCounseling() {
        return counseling;
    }

    public void setCounseling(Counseling counseling) {
        this.counseling = counseling;
    }
}
