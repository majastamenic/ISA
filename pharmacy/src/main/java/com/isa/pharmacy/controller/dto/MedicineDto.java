package com.isa.pharmacy.controller.dto;

public class MedicineDto {
	
	private Long code;
	private String name;
	private String type;
	private String form;
	private String manufactured;
	private String publishingType;
	private String node;
	
	public MedicineDto() {}

	public MedicineDto(Long code, String name, String type, String form, String manufactured, String publishingType,
			String node) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.form = form;
		this.manufactured = manufactured;
		this.publishingType = publishingType;
		this.node = node;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
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

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
	

}
