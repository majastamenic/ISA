package com.isa.pharmacy.rabbitmq;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	public ActionsAndBenefits() {}
	
	public ActionsAndBenefits(Long id, String messageAboutAction, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.messageAboutAction = messageAboutAction;
		this.startDate = startDate;
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "Action [id=" + id + ", message = " + messageAboutAction + "]";
	}

}
