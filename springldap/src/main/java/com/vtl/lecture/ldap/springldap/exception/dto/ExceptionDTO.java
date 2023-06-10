package com.vtl.lecture.ldap.springldap.exception.dto;

public class ExceptionDTO {
	
	private String httpStatusCode;
	private String statusMessage;
	public String getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	

}
