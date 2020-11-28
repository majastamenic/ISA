package com.isa.pharmacy.rabbitmq;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//Order = Hospital
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ActionsAndBenefits.class)
public class ActionsAndBenefits {
	
	private Long id;
	private String messageAboutAction;
	
	public ActionsAndBenefits() {}
	
	public ActionsAndBenefits(Long id, String messageAboutAction) {
		super();
		this.id = id;
		this.messageAboutAction = messageAboutAction;
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
	
	@Override
	public String toString() {
		return "Action [id=" + id + ", message = " + messageAboutAction + "]";
	}

}
