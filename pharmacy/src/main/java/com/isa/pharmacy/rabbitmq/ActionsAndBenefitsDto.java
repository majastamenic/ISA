package com.isa.pharmacy.rabbitmq;

import java.util.Date;

public class ActionsAndBenefitsDto {
	
	private String message;
	private Date startDate;
	private Date endDate;
	
	public ActionsAndBenefitsDto(String message, Date startDate, Date endDate) {
		super();
		this.message = message;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

}
