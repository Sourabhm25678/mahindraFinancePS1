package com.lead.demo.bean;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5194654003090331442L;

	private String code;
	
	private List<String> messages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
