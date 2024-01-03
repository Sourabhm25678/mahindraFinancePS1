package com.lead.demo.bean;

import java.io.Serializable;
import java.util.List;

public class FetchLeadResponse implements Serializable {

	private static final long serialVersionUID = 2713846942727123986L;

	private String status;

	private List<LeadBean> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LeadBean> getData() {
		return data;
	}

	public void setData(List<LeadBean> data) {
		this.data = data;
	}
	
}
