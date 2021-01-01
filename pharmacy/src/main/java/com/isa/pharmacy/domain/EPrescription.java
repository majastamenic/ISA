package com.isa.pharmacy.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class EPrescription implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    @Column
    private String patientName;    //Ime i prezime
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssue;
    @ElementCollection
    private List<MedicineEPrescription> listOfMedication; //Sifra leka, naziv i kolicina

    @Column
    private String fileText;

    public EPrescription() {
    }


    public EPrescription(Long id, String code, String patientName, Date dateOfIssue, List<MedicineEPrescription> listOfMedication,
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
