package com.isa.pharmacy.controller.dto;

public class PharmacyDto {
    private Long id;
    private String name;
    private String address;
    private Integer counselingPrice;

    public PharmacyDto(){}

    public PharmacyDto(Long id,String name, String address, Integer counselingPrice) {
        this.id= id;
        this.name = name;
        this.address = address;
        this.counselingPrice = counselingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCounselingPrice() {
        return counselingPrice;
    }

    public void setCounselingPrice(Integer counselingPrice) {
        this.counselingPrice = counselingPrice;
    }
}
