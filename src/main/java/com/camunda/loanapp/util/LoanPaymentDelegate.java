package com.camunda.loanapp.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camunda.loanapp.model.ApplicantInfo;
import com.camunda.loanapp.model.LoanPayment;
import com.camunda.loanapp.service.LoanApplicantService;

public class LoanPaymentDelegate implements JavaDelegate {

	private final Logger LOGGER = LoggerFactory.getLogger(LoanPaymentDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		LoanApplicantService loanApplicantService = new LoanApplicantService();
		ApplicantInfo applicant = new ApplicantInfo();
		LoanPayment loanPayment = new LoanPayment();
		String loanDecision = (String) execution.getVariable("loanDecision");
		Long personalId = (Long) execution.getVariable("personalId");
		String loanPaymentStatus = (String) execution.getVariable("loanPaymentStatus");
		Long paymentAmount = (Long) execution.getVariable("paymentAmount");
		
		String activityId = execution.getCurrentActivityId();
		if(activityId.equals("inform_Loan_Decision"))
		{
		LOGGER.info("Loan decision : " + loanDecision);
		
		
		applicant.setLoanDecision(loanDecision);
		applicant.setPersonalId(personalId);
		
		loanApplicantService.updateApplicantwithLoanDeicision(applicant);
		}
		else if(activityId.equals("update_Payment_Status"))
		{
			applicant.setPersonalId(personalId);
			applicant.setLoanPaymentStatus(loanPaymentStatus);
			loanApplicantService.updateLoanPaymentStatus(applicant);	
		}
		else if(activityId.equals("update_Payment_Details"))
		{
			loanPayment.setPersonalId(personalId);
			loanPayment.setPaymentAmount(paymentAmount);
			loanApplicantService.loanPaymentDoneByCustomer(loanPayment);
		}

	}

}
