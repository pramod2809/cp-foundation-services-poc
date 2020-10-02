package com.cs.cp.tcb.exceptions;

import com.cs.cp.tcb.config.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);

	@Autowired
	private ConfigProperties configProp;
	
	  @ExceptionHandler(RuntimeException.class)
	  public final ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
		LOGGER.error("Exception occured at handleRuntimeException = {}",ex.getMessage());
	    ErrorDto exceptionResponse = new ErrorDto(new Date(), ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  @ExceptionHandler(ApplicationException.class)
	  public final ResponseEntity<ErrorDto> handleApplicationException(ApplicationException ex) {
		LOGGER.error("Exception occured at  handleApplicationException= {} , {} ",ex.getMessageCode(), ex.getMessageParameters());
	    ErrorDto exceptionResponse = new ErrorDto(new Date(), ex.getMessageCode(), this.getLocalizedMessage(ex.getMessageCode(), ex.getMessageParameters()));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  }
	  
	  private String getLocalizedMessage(String messageCode, Object[] messageParams) {
	  	String errorMessage = configProp.getConfigValue("app.exception"+"."+messageCode);
	  	String formatMessage = String.format(errorMessage, messageParams);
	  	return formatMessage;
	  }

	}