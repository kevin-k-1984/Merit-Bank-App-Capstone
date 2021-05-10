package com.meritamerica.assignment7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceedsFraudSuspicionLimitException extends Exception {
	
    public ExceedsFraudSuspicionLimitException(String message) { 
    	super(message);
    }
}