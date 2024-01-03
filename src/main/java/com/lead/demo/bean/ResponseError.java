package com.lead.demo.bean;

import java.io.Serializable;

public class ResponseError implements Serializable {

	private static final long serialVersionUID = 1526098500935101816L;
	
	private String status;
	
	private ErrorResponse errorResponse;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
