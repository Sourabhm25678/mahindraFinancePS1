package com.lead.demo.bean;

import java.io.Serializable;

public class ResponseSuccess implements Serializable {

	private static final long serialVersionUID = -5212773637452471893L;
	
	private String status;

	private String data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
