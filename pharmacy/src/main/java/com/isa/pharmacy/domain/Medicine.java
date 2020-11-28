package com.isa.pharmacy.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.isa.pharmacy.domain.enums.MedicinePublishingType;

@Entity
@Table
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private Long code;
	@Column
	private String name;
	@Column 
	private String typeOfMedicine;
	@Column
	private String formOfMedicine;
	@ElementCollection
	private List<String> composition;
	@Column
	private String manufactured;
	@Column
	private MedicinePublishingType publishingType;
	@ElementCollection
	private List<String> replacementMedicines;
	@Column
	private String note;
	@OneToMany
	private List<MedicinePharmacy> medicinePharmacy;
	
	public Medicine() {}
	
	public Medicine(Long id, Long code, String name, String typeOfMedicine, String formOfMedicine,
			List<String> composition, String manufactured, MedicinePublishingType publishingType,
			List<String> replacementMedicines, String note, List<MedicinePharmacy> medicinePharmacy) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.typeOfMedicine = typeOfMedicine;
		this.formOfMedicine = formOfMedicine;
		this.composition = composition;
		this.manufactured = manufactured;
		this.publishingType = publishingType;
		this.replacementMedicines = replacementMedicines;
		this.note = note;
		this.medicinePharmacy = medicinePharmacy;
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

	public List<String> getReplacementMedicine() {
		return replacementMedicines;
	}

	public void setReplacementMedicine(List<String> replacementMedicines) {
		this.replacementMedicines = replacementMedicines;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<MedicinePharmacy> getMedicinePharmacy() {
		return medicinePharmacy;
	}

	public void setMedicinePharmacy(List<MedicinePharmacy> medicinePharmacy) {
		this.medicinePharmacy = medicinePharmacy;
	}
	
	
	
}