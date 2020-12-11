package com.isa.pharmacy.controller.dto;

import java.util.List;



import com.isa.pharmacy.domain.enums.MedicinePublishingType;

public class MedicineDTO {
	private Long code;	
	private String name;	
	private String typeOfMedicine;	
	private String formOfMedicine;	
	private List<String> composition;	
	private String manufactured;	
	private MedicinePublishingType publishingType;	
	private List<String> replacementMedicines;

	
	public MedicineDTO() {
		super();
	}
	
	public MedicineDTO(Long code, String name, String typeOfMedicine, String formOfMedicine, List<String> composition,
			String manufactured, MedicinePublishingType publishingType, List<String> replacementMedicines) {
		super();
		this.code = code;
		this.name = name;
		this.typeOfMedicine = typeOfMedicine;
		this.formOfMedicine = formOfMedicine;
		this.composition = composition;
		this.manufactured = manufactured;
		this.publishingType = publishingType;
		this.replacementMedicines = replacementMedicines;
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


	public MedicinePublishingType getPublishingType() {
		return publishingType;
	}


	public void setPublishingType(MedicinePublishingType publishingType) {
		this.publishingType = publishingType;
	}


	public List<String> getReplacementMedicines() {
		return replacementMedicines;
	}


	public void setReplacementMedicines(List<String> replacementMedicines) {
		this.replacementMedicines = replacementMedicines;
	}


	
	
}
