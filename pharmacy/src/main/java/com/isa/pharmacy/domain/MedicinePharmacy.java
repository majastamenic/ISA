package com.isa.pharmacy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicinePharmacy")
public class MedicinePharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private double price;
	@Column
	private int quantity;
	@ManyToOne
	private Medicine medicine;
	@ManyToOne
	private Pharmacy pharmacy;
	
	public MedicinePharmacy() {}
	
	public MedicinePharmacy(long id, double price, Medicine medicine, Pharmacy pharmacy) {
		super();
		this.id = id;
		this.price = price;
		this.medicine = medicine;
		this.pharmacy = pharmacy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	
	
	

}
