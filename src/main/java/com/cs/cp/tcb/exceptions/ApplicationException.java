package com.cs.cp.tcb.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ApplicationException extends Exception{
	public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);
	
    private String messageCode;
    private Object[] messageParameters;
    
	protected ApplicationException(String messageCode) {
		this(messageCode, null, null);
	}
	
	protected ApplicationException(String messageCode, Object[] messageParameters) {
		this(messageCode, messageParameters, null);
	}

	protected ApplicationException(String messageCode, Object[] messageParameters, Throwable cause) {
		super(cause);
		this.messageCode = messageCode;
		this.messageParameters = messageParameters;
	}

	/*public ApplicationException(ErrorMessages recordAlreadyExists, Object[] messageParameters) {
		this(recordAlreadyExists.toString(), messageParameters, null);
	}*/

	public String getMessageCode() {
		return messageCode;
	}

	public Object[] getMessageParameters() {
		return messageParameters;
	}

}
