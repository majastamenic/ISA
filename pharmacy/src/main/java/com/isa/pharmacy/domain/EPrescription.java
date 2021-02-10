package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class EPrescription implements Serializable {
    private static final long serialVersionUID = 9111153783414830667L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long code;
    @Column
    private String patientName;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dateOfIssue;
    @OneToMany
    private List<MedicineEPrescription> listOfMedication;
    @Column
    private String fileText;

    public EPrescription() { }

    public EPrescription(Long id, Long code, String patientName, Date dateOfIssue, List<MedicineEPrescription> listOfMedication,
                         String fileText) {
        super();
        this.id = id;
        this.code = code;
        this.patientName = patientName;
        this.dateOfIssue = dateOfIssue;
        this.listOfMedication = listOfMedication;
        this.fileText = fileText;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public List<MedicineEPrescription> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(List<MedicineEPrescription> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

}
