package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Prescription {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String note;
    @OneToOne
    private Examination examination;
    @ElementCollection
    private List<Diagnosis> diagnoses;
    @ElementCollection
    private List<MedicinePharmacy> medicines;

    public Prescription(){}

    public Prescription(Long id, String note, Examination examination, List<Diagnosis> diagnoses, List<MedicinePharmacy> medicines) {
        this.id = id;
        this.note = note;
        this.examination = examination;
        this.diagnoses = diagnoses;
        this.medicines = medicines;
    }

    public List<MedicinePharmacy> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicinePharmacy> medicines) {
        this.medicines = medicines;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
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

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }
}
