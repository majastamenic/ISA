package com.isa.pharmacy.rabbitmq;

import java.util.Date;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.isa.pharmacy.domain.Pharmacy;

//Order = Hospital
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ActionsAndBenefits.class)
@Entity
@Table(name = "actions")
public class ActionsAndBenefits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String messageAboutAction;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @ManyToOne
    private Pharmacy pharmacy;

    public ActionsAndBenefits() {
    }

    public ActionsAndBenefits(Long id, String messageAboutAction, Date startDate, Date endDate, Pharmacy pharmacy) {
        super();
        this.id = id;
        this.messageAboutAction = messageAboutAction;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageAboutAction() {
        return messageAboutAction;
    }

    public void setMessageAboutAction(String messageAboutAction) {
        this.messageAboutAction = messageAboutAction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "Action [id=" + id + ", message = " + messageAboutAction + "]";
    }


}
