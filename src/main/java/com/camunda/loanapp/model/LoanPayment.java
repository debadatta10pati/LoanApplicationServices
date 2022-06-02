package com.camunda.loanapp.model;

public class LoanPayment {

	private Long paymentAmount;
	
	private Long personalId;


	public LoanPayment() {

	}


	public Long getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(Long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public Long getPersonalId() {
		return personalId;
	}


	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}


}
