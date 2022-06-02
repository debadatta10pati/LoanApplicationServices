package com.camunda.loanapp.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camunda.loanapp.model.ApplicantInfo;
import com.camunda.loanapp.service.LoanApplicantService;

public class ApplicantListener implements ExecutionListener {

	private final Logger LOGGER = LoggerFactory.getLogger(ApplicantListener.class.getName());

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		Long personalId = (Long) execution.getVariable("personalId");

		// Date formatter

		LoanApplicantService loanApplicantService = new LoanApplicantService();
		ApplicantInfo result = loanApplicantService.fetchApplicant(personalId);
		if (result != null) {
			execution.setVariable("applicantPresent", "Yes");
			execution.setVariable("name", result.getName());
			execution.setVariable("surName", result.getSurName());
			execution.setVariable("email", result.getEmail());
			if (result.getLoanPaymentStatus() != null) {
				execution.setVariable("loanPaymentStatus", result.getLoanPaymentStatus());
			} else {
				execution.setVariable("loanPaymentStatus", "Standard");
			}
		} else {
			execution.setVariable("applicantPresent", "No");

		}

		LOGGER.info(" Loan payment status set to " + execution.getVariable("loanPaymentStatus")
				+ " Is applicant present ? " + execution.getVariable("applicantPresent"));
	}

}
