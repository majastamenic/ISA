package com.isa.pharmacy.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class ePrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String code;
	@Column
	private String patientName;	//Ime i prezime
	@Column
	private Date dateOfIssue;
	@ElementCollection		//TODO: Umesto liste stringova, lista objekata?
	private List<String> listOfMedication; //Sifra leka, naziv i kolicina
	
	public ePrescription() {}	
	
	public ePrescription(Long id, String code, String patientName, Date dateOfIssue, List<String> listOfMedication) {
		super();
		this.id = id;
		this.code = code;
		this.patientName = patientName;
		this.dateOfIssue = dateOfIssue;
		this.listOfMedication = listOfMedication;
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
	public List<String> getListOfMedication() {
		return listOfMedication;
	}
	public void setListOfMedication(List<String> listOfMedication) {
		this.listOfMedication = listOfMedication;
	}
	
	

}
