package com.isa.pharmacy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, nullable = false)
	private String email;
	@Column
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apiKey;
	
	public Hospital() {}
	
	public Hospital(String email, String name, Long apiKey) {
		super();
		this.email = email;
		this.name = name;
		this.apiKey = apiKey;
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
	public Long getApiKey() {
		return apiKey;
	}
	public void setApiKey(Long apiKey) {
		this.apiKey = apiKey;
	}
	
	

}
