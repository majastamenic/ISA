package com.isa.pharmacy.controller.dto;

public class CreateComplaintDto {

    private String subject;
    private String complaintText;
    private String patientEmail;

    public CreateComplaintDto(){}

    public CreateComplaintDto(String subject, String complaintText, String patientEmail) {
        this.subject = subject;
        this.complaintText = complaintText;
        this.patientEmail = patientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
