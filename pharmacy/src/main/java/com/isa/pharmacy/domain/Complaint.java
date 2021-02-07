package com.isa.pharmacy.domain;

import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Complaint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String complaintMessage;
    @Column
    private String responseComplaint;
    @ManyToOne
    private Patient patient;

    public Complaint(){}

    public Complaint(Long id, String complaintMessage, String responseComplaint, Patient patient) {
        this.id = id;
        this.complaintMessage = complaintMessage;
        this.responseComplaint = responseComplaint;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplaintMessage() {
        return complaintMessage;
    }

    public void setComplaintMessage(String complaintMessage) {
        this.complaintMessage = complaintMessage;
    }

    public String getResponseComplaint() {
        return responseComplaint;
    }

    public void setResponseComplaint(String responseComplaint) {
        this.responseComplaint = responseComplaint;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
