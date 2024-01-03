package com.lead.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lead.demo.bean.FetchLeadResponse;
import com.lead.demo.bean.LeadRequestBean;
import com.lead.demo.bean.ResponseError;
import com.lead.demo.bean.ResponseSuccess;
import com.lead.demo.service.LeadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@Validated
@Tag(name = "lead-controller", description = "Lead Controller")
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@PostMapping("/v1/lead/create")
	@Operation(operationId = "createLead", summary = "Lead creation endpoint", description = "API to create a lead")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lead Already Exists in the database with the lead id.", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResponseError.class)) }),
			@ApiResponse(responseCode = "201", description = "Lead created successfully.", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResponseSuccess.class)) }) })
	public ResponseEntity<Object> createLead(@RequestBody @Valid LeadRequestBean leadRequestBean, BindingResult bindingResult) {
		
		return leadService.createLeadinDB(leadRequestBean);
	}
	
	@GetMapping(value = "/v1/lead/{mobileNumber}")
	@Operation(operationId = "fetchLead", summary = "Fetch lead details.", description = "API to fetch lead details against mobile n umber")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "No Lead found with the Mobile Number.", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResponseError.class)) }),
			@ApiResponse(responseCode = "201", description = "Leads fetched successfully.", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FetchLeadResponse.class)) }) })
	public ResponseEntity<Object> fetchLead(
			@PathVariable(required = true) @NotBlank(message = "mobileNumber can not be null or empty") @Parameter(description = "mobileNumber", example = "9999888877") @Pattern(regexp = "[\\d]+", message = "Enter valid mobileNumber") String mobileNumber) {
		
		return leadService.fetchLeads(mobileNumber);
	}
	

}
