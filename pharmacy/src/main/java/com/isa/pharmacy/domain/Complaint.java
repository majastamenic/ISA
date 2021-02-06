package com.isa.pharmacy.domain;

import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import org.graalvm.compiler.lir.LIRInstruction;

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
    private User user;

    public Complaint(){}

    public Complaint(Long id, String complaintMessage, String responseComplaint, User user) {
        this.id = id;
        this.complaintMessage = complaintMessage;
        this.responseComplaint = responseComplaint;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
