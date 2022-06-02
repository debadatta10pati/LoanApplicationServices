package com.camunda.loanapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camunda.loanapp.model.ApplicantInfo;
import com.camunda.loanapp.service.LoanApplicantService;

public class NotificationExecutionListener implements ExecutionListener {

	private final Logger LOGGER = LoggerFactory.getLogger(NotificationExecutionListener.class.getName());

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		String name = (String) execution.getVariable("name");
		String surName = (String) execution.getVariable("surName");
		String email = (String) execution.getVariable("email");
		Date dob = (Date) execution.getVariable("dob");

		// Date formatter

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		String dateOfBirth = dateFormat.format(dob);

		Long personalId = (Long) execution.getVariable("personalId");
		Long loanAmount = (Long) execution.getVariable("loanAmount");
		Long loanTerm = (Long) execution.getVariable("loanTerm");

		LOGGER.info("Task details : First Name " + name + "Activity Instance Id" + execution.getActivityInstanceId()
				+ " Activity name : " + execution.getCurrentActivityName());

		LoanApplicantService loanApplicantService = new LoanApplicantService();

		ApplicantInfo applicantData = new ApplicantInfo();

		applicantData.setEmail(email);
		applicantData.setLoanAmount(loanAmount);
		applicantData.setSurName(surName);
		applicantData.setPersonalId(personalId);
		applicantData.setName(name);
		applicantData.setLoanTerm(loanTerm);
		applicantData.setDob(dateOfBirth);
		Date currentDate = new Date();

		long age = currentDate.getYear() - dob.getYear();
		applicantData.setAge(age);

		loanApplicantService.saveApplicantData(applicantData);

		// Calculate age

		LOGGER.info("Applicant age = " + age);
		execution.setVariable("age", age);

	}

}
