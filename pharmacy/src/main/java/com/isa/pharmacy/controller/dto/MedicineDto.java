package com.isa.pharmacy.controller.dto;

import java.util.List;

import com.isa.pharmacy.domain.Pharmacy;

public class MedicineDto {
	private Long code;	
	private String name;	
	private String typeOfMedicine;	
	private String formOfMedicine;	
	private List<String> composition;	
	private String manufactured;	
	private String publishingType;	
	private List<String> replacementMedicines;
	private double price;
	private int quantity;
	private Pharmacy pharmacy;
	private String note;
	private List<String> replacementMedicine;

	
	public MedicineDto() {
		super();
	}


	public MedicineDto(Long code, String name, String typeOfMedicine, String formOfMedicine, List<String> composition,
			String manufactured, String publishingType, List<String> replacementMedicines, double price,
			int quantity, Pharmacy pharmacy, String note, List<String> replacementMedicine) {
		super();
		this.code = code;
		this.name = name;
		this.typeOfMedicine = typeOfMedicine;
		this.formOfMedicine = formOfMedicine;
		this.composition = composition;
		this.manufactured = manufactured;
		this.publishingType = publishingType;
		this.replacementMedicines = replacementMedicines;
		this.price = price;
		this.quantity = quantity;
		this.pharmacy = pharmacy;
		this.note = note;
		this.replacementMedicine = replacementMedicine;
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


	public List<String> getReplacementMedicines() {
		return replacementMedicines;
	}


	public void setReplacementMedicines(List<String> replacementMedicines) {
		this.replacementMedicines = replacementMedicines;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Pharmacy getPharmacy() {
		return pharmacy;
	}


	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public List<String> getReplacementMedicine() {
		return replacementMedicine;
	}


	public void setReplacementMedicine(List<String> replacementMedicine) {
		this.replacementMedicine = replacementMedicine;
	}
	
	
	
	
	
}
