package com.camunda.loanapp.model;

public class ApplicantInfo {

	private String name;

	private String surName;

	private Long personalId;

	private Long age;

	private String dob;

	public String email;

	public Long loanAmount;

	public String loanDecision;

	public String loanPaymentStatus;

	private Long loanTerm;

	private Long monthlyInstallment;

	private Long loanTermsPaid;

	private Long unPaidPrincipal;

	public ApplicantInfo() {

	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getMonthlyInstallment() {
		return monthlyInstallment;
	}

	public void setMonthlyInstallment(Long monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	public Long getLoanTermsPaid() {
		return loanTermsPaid;
	}

	public void setLoanTermsPaid(Long loanTermsPaid) {
		this.loanTermsPaid = loanTermsPaid;
	}

	public Long getUnPaidPrincipal() {
		return unPaidPrincipal;
	}

	public void setUnPaidPrincipal(Long unPaidPrincipal) {
		this.unPaidPrincipal = unPaidPrincipal;
	}

	public Long getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(Long loanTerm) {
		this.loanTerm = loanTerm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanDecision() {
		return loanDecision;
	}

	public void setLoanDecision(String loanDecision) {
		this.loanDecision = loanDecision;
	}

	public String getLoanPaymentStatus() {
		return loanPaymentStatus;
	}

	public void setLoanPaymentStatus(String loanPaymentStatus) {
		this.loanPaymentStatus = loanPaymentStatus;
	}

	@Override
	public String toString() {
		return "ApplicantInfo [name=" + name + ", surName=" + surName + ", personalId=" + personalId + ", dob=" + dob
				+ ", email=" + email + ", loanAmount=" + loanAmount + ", loanDecision=" + loanDecision
				+ ", loanPaymentStatus=" + loanPaymentStatus + ", loanTerm=" + loanTerm + ", monthlyInstallment="
				+ monthlyInstallment + ", loanTermsPaid=" + loanTermsPaid + ", unPaidPrincipal=" + unPaidPrincipal
				+ "]";
	}

}
