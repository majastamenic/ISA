package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;

import java.util.List;

public class MedicineDto {

	private Long code;	
	private String name;	
	private String typeOfMedicine;	
	private FormOfMedicine formOfMedicine;
	private String composition;
	private String manufactured;	
	private MedicinePublishingType publishingType;
	private List<Long> alternative;
	private double price;
	private int amount;
	private String note;
	private String pharmacyName;

	
	public MedicineDto() {
		super();
	}

	public MedicineDto(Long code, String name, String typeOfMedicine, FormOfMedicine formOfMedicine, String composition, String manufactured, MedicinePublishingType publishingType, List<Long> alternative, double price, int amount, String note, String pharmacyName) {
		this.code = code;
		this.name = name;
		this.typeOfMedicine = typeOfMedicine;
		this.formOfMedicine = formOfMedicine;
		this.composition = composition;
		this.manufactured = manufactured;
		this.publishingType = publishingType;
		this.alternative = alternative;
		this.price = price;
		this.amount = amount;
		this.note = note;
		this.pharmacyName = pharmacyName;
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

	public List<Long> getAlternative() {
		return alternative;
	}

	public void setAlternative(List<Long> alternative) {
		this.alternative = alternative;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
}
