package com.camunda.loanapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.camunda.loanapp.model.ApplicantInfo;
import com.camunda.loanapp.model.LoanPayment;

@Service
public class LoanApplicantService {

	private final Logger LOGGER = LoggerFactory.getLogger(LoanApplicantService.class.getName());

	public ApplicantInfo fetchApplicant(Long personalId) throws Exception {

		String uri = "http://localhost:8091/loan/getApplicant/" + personalId;

		RestTemplate restTemplate = new RestTemplate();
		
	//	ResponseEntity<ApplicantInfo> response = restTemplate.getForEntity(uri,ApplicantInfo.class);

	
		ApplicantInfo result = restTemplate.getForObject(uri, ApplicantInfo.class);
		LOGGER.info(" Response received "+result);
		

		return result;

	}

	public void saveApplicantData(ApplicantInfo applicant) {

		String uri = "http://localhost:8091/loan/saveApplicant";

		RestTemplate restTemplate = new RestTemplate();

		ApplicantInfo info = restTemplate.postForObject(uri, applicant, ApplicantInfo.class);


	}
	
	public void updateApplicantwithLoanDeicision(ApplicantInfo applicant) {

		String uri = "http://localhost:8091/loan/updateLoanDecisionByLoanDepartment";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.put(uri, applicant);
				

		LOGGER.info(" Sent email to customer with deicision "+applicant.getLoanDecision());
		LOGGER.info(" Informed customer department "+applicant.getLoanDecision());
	}
	

	public void loanPaymentDoneByCustomer(LoanPayment loanPayment) {

		String uri = "http://localhost:8091/loan/loanPaymentDoneByCustomer";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(uri, loanPayment, LoanPayment.class);

	}
	
	public void updateLoanPaymentStatus(ApplicantInfo applicant) {

		String uri = "http://localhost:8091/loan/updateLoanPaymentStatus";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(uri, applicant, ApplicantInfo.class);

	}

}
