package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;

import java.util.List;

public class AddMedicineDto {
    private Long code;
    private String name;
    private String typeOfMedicine;
    private FormOfMedicine formOfMedicine;
    private String composition;
    private String manufactured;
    private MedicinePublishingType publishingType;
    private List<Long> replacementMedicines;
    private String note;

    public AddMedicineDto(Long code, String name, String typeOfMedicine, FormOfMedicine formOfMedicine, String composition, String manufactured, MedicinePublishingType publishingType, List<Long> replacementMedicines, String note) {
        this.code = code;
        this.name = name;
        this.typeOfMedicine = typeOfMedicine;
        this.formOfMedicine = formOfMedicine;
        this.composition = composition;
        this.manufactured = manufactured;
        this.publishingType = publishingType;
        this.replacementMedicines = replacementMedicines;
        this.note = note;
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

    public List<Long> getReplacementMedicines() {
        return replacementMedicines;
    }

    public void setReplacementMedicines(List<Long> replacementMedicines) {
        this.replacementMedicines = replacementMedicines;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
