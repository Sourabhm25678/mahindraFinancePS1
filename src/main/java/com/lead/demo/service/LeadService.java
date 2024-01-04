package com.lead.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.lead.demo.bean.ErrorResponse;
import com.lead.demo.bean.FetchLeadResponse;
import com.lead.demo.bean.LeadBean;
import com.lead.demo.bean.LeadRequestBean;
import com.lead.demo.bean.ResponseError;
import com.lead.demo.bean.ResponseSuccess;
import com.lead.demo.entity.Lead;
import com.lead.demo.repository.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
	private LeadRepository leadRepository;
	
	/**
	 * Create Lead in database.
	 * 
	 * @implNote This is the implementation of the service layer for
	 *           {@link com.lead.demo.controller.LeadController#createLead(LeadRequestBean, org.springframework.validation.BindingResult) 
	 *           createLead}. It's function is to create a new lead in database
	 *           if no lead exists with same leadIs. Otherwise, return an error response.
	 * @param leadRequest {@code LeadRequestBean} LeadRequestBean
	 * @return {@code Object} Response body will have http status
	 *         code along with the response body.
	 */
	public ResponseEntity<Object> createLeadinDB(LeadRequestBean leadRequest) {
		
		Lead l1 = leadRepository.findByLeadId(leadRequest.getLeadId());
		if(!ObjectUtils.isEmpty(l1)) {
			ResponseError errorBean = populateErrorResponse();
			return new ResponseEntity<>(errorBean, HttpStatus.OK);
		}
		
		l1 = createNewLead(leadRequest);
		leadRepository.save(l1);
		ResponseSuccess responseBean = populateSuccessResponse();
		return new ResponseEntity<>(responseBean, HttpStatus.CREATED);
	}
	
	/**
	 * Fetch Lead from database.
	 * 
	 * @implNote This is the implementation of the service layer for
	 *           {@link com.lead.demo.controller.LeadController#fetchLead(String) 
	 *           fetchLead}. It's function is to fetch lead from database
	 *           on the basis of mobileNumber. If no record is present in database,
	 *           return error response.
	 * @param mobileNumber {@code String} mobileNumber
	 * @return {@code Object} Response body will have http status
	 *         code along with the response body.
	 */
	public ResponseEntity<Object> fetchLeads(String mobileNumber) {
		
		List<Lead> leads = leadRepository.findByMobileNumber(mobileNumber);
		if(ObjectUtils.isEmpty(leads)) {
			ResponseError errorBean = populateResponse();
			return new ResponseEntity<>(errorBean, HttpStatus.OK);
		}
		
		List<LeadBean> leadData = createLeadList(leads);
		FetchLeadResponse response = new FetchLeadResponse();
		response.setStatus("success");
		response.setData(leadData);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	private List<LeadBean> createLeadList(List<Lead> leads) {
		//LeadBean is created because of the response requirement.
		List<LeadBean> leadList = new ArrayList<>();
		for(Lead l2 : leads) {
			LeadBean leadBean = new LeadBean();
			leadBean.setLeadId(l2.getLeadId());
			leadBean.setFirstName(l2.getFirstName());
			leadBean.setMiddleName(l2.getMiddleName());
			leadBean.setMobileNumber(l2.getMobileNumber());
			leadBean.setGender(l2.getGender());
			leadBean.setDOB(l2.getDOB());
			leadBean.setEmail(l2.getEmail());
			leadList.add(leadBean);
		}
		return leadList;
	}
	
	private Lead createNewLead(LeadRequestBean leadRequest) {
		Lead newLead = new Lead();
		newLead.setLeadId(leadRequest.getLeadId());
		newLead.setFirstName(leadRequest.getFirstName());
		newLead.setMiddleName(leadRequest.getMiddleName());
		newLead.setLastName(leadRequest.getLastName());
		newLead.setMobileNumber(leadRequest.getMobileNumber());
		newLead.setGender(leadRequest.getGender());
		newLead.setDOB(leadRequest.getDOB());
		newLead.setEmail(leadRequest.getEmail());
		return newLead;
	}
	
	private ResponseSuccess populateSuccessResponse() {
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.setStatus("success");
		responseSuccess.setData("Created Lead Successfully");
		return responseSuccess;
	}
	
	private ResponseError populateErrorResponse() {
		List<String> messages = new ArrayList<>();
		messages.add("Lead Already Exists in the database with the lead id");
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("E10010");
		errorResponse.setMessages(messages);
		
		ResponseError responseError = new ResponseError();
		responseError.setStatus("error");
		responseError.setErrorResponse(errorResponse);
		return responseError;
	}
	
	private ResponseError populateResponse() {
		List<String> messages = new ArrayList<>();
		messages.add("No Lead found with the Mobile Number");
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("E10011");
		errorResponse.setMessages(messages);
		
		ResponseError responseError = new ResponseError();
		responseError.setStatus("error");
		responseError.setErrorResponse(errorResponse);
		return responseError;
	}

}
