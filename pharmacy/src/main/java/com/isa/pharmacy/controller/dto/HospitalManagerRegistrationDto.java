package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Pharmacy;

public class HospitalManagerRegistrationDto {
	
	private String email;
	private String name;
	private Pharmacy pharmacy;
	
	public HospitalManagerRegistrationDto() {}
	
	public HospitalManagerRegistrationDto(String name, String email, Pharmacy pharmacy) {
		super();
		this.email = email;
		this.name = name;
		this.pharmacy = pharmacy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	

}
