package com.isa.pharmacy.rabbitmq;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//Order = Hospital
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = RabbitMQActions.class)
public class RabbitMQActions {
	
	private long id;
	private String messageAboutAction;
	
	public RabbitMQActions() {}
	
	public RabbitMQActions(long id, String messageAboutAction) {
		super();
		this.id = id;
		this.messageAboutAction = messageAboutAction;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
