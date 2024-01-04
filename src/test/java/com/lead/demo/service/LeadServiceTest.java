package com.lead.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lead.demo.bean.LeadRequestBean;
import com.lead.demo.entity.Lead;
import com.lead.demo.repository.LeadRepository;

@ExtendWith(MockitoExtension.class)
class LeadServiceTest {
	
	@InjectMocks
	private LeadService leadService;
	
	@Mock
	private LeadRepository leadRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void createLeadinDB_success() {
		LeadRequestBean leadRequest = prepareRequest();
		
		when(leadRepository.findByLeadId(Mockito.anyString())).thenReturn(null);
		assertNotNull(leadService.createLeadinDB(leadRequest));
	}
	
	@Test
	void createLeadinDB_ResponseError() {
		Lead lead = new Lead();
		LeadRequestBean leadRequest = new LeadRequestBean();
		leadRequest.setLeadId("1234");
		
		when(leadRepository.findByLeadId(Mockito.anyString())).thenReturn(lead);
		assertNotNull(leadService.createLeadinDB(leadRequest));
	}
	
	@Test
	void fetchLeads_success() {
		Lead lead = new Lead();
		lead.setLeadKey(1234l);
		lead.setLeadId("1234");
		lead.setFirstName("firstName");
		lead.setMiddleName("middleName");
		lead.setLastName("lastName");
		lead.setMobileNumber("9999888822");
		lead.setGender("Male");
		lead.setDOB("10/12/1999");
		lead.setEmail("asdf@gmail.com");
		lead.toString();
		List<Lead> leadList = new ArrayList<>();
		leadList.add(lead);
		
		when(leadRepository.findByMobileNumber(Mockito.anyString())).thenReturn(leadList);
		assertNotNull(leadService.fetchLeads("9999888822"));
	}
	
	@Test
	void fetchLeads_ResponseError() {
		
		when(leadRepository.findByMobileNumber(Mockito.anyString())).thenReturn(null);
		assertNotNull(leadService.fetchLeads("9999888822"));
	}
	
	private LeadRequestBean prepareRequest() {
		LeadRequestBean leadRequest = new LeadRequestBean();
		leadRequest.setLeadId("1234");
		leadRequest.setFirstName("firstName");
		leadRequest.setMiddleName("middleName");
		leadRequest.setLastName("lastName");
		leadRequest.setMobileNumber("9999888822");
		leadRequest.setGender("Male");
		leadRequest.setDOB("10/12/1999");
		leadRequest.setEmail("asdf@gmail.com");
		return leadRequest;
	}

}
