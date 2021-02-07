package com.isa.pharmacy.controller.dto.complaint;

public class ShowComplaintDto {

    private Long id;
    private String patientName;
    private String message;
    private String response;

    public ShowComplaintDto(){}

    public ShowComplaintDto(Long id, String patientName, String message, String response) {
        this.id = id;
        this.patientName = patientName;
        this.message = message;
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
