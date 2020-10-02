package com.cs.cp.tcb.exceptions;

import java.util.Date;

public class ErrorDto {
	  private Date timestamp;
	  private String errorCode;
	  private String errorMessage;

	public ErrorDto(Date timestamp, String errorCode, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	}