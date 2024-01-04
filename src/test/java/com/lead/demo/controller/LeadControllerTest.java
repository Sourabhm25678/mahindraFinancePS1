package com.lead.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lead.demo.bean.LeadRequestBean;
import com.lead.demo.entity.Lead;
import com.lead.demo.service.LeadService;

@ExtendWith(MockitoExtension.class)
class LeadControllerTest {
	
	@InjectMocks
	private LeadController leadController;
	
	@Mock
	private LeadService leadService;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(leadController).build();
	}
	
	@Test
	void createLead() throws Exception {
		LeadRequestBean leadRequest = new LeadRequestBean();
		leadRequest.setLeadId("1234");
		ResponseEntity<Object> response = new ResponseEntity<>(leadRequest, HttpStatus.OK);
		when(leadService.createLeadinDB(Mockito.any())).thenReturn(response);
		mockMvc.perform(post("/v1/lead/create").content(new ObjectMapper().writeValueAsString(leadRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void fetchLead() throws Exception {
		Lead lead = new Lead();
		lead.setLeadId("1234");
		ResponseEntity<Object> response = new ResponseEntity<>(lead, HttpStatus.OK);
		when(leadService.fetchLeads(Mockito.anyString())).thenReturn(response);
		mockMvc.perform(get("/v1/lead/{mobileNumber}", "9999888822")).andExpect(status().isOk());
	}
	
}
