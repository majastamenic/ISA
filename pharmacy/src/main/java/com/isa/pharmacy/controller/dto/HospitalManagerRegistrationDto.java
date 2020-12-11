package com.isa.pharmacy.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.isa.pharmacy.domain.Pharmacy;
import com.sun.istack.NotNull;

public class HospitalManagerRegistrationDto {
	
	@NotEmpty(message = "{validation.email.NotEmpty}")
	@Email(message = "{validation.email.Type}")
    private String email;
	@NotEmpty(message = "{validation.name.NotEmpty}")
	private String name;
	@NotNull
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
