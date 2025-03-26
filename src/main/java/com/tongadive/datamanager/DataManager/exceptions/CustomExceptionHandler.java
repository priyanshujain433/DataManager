package com.tongadive.datamanager.DataManager.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {
	
	
	    @ExceptionHandler(UserNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public Map<String, String> handleUserNotFoundException(UserNotFoundException ex) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", ex.getMessage());
	        return errorResponse;
	    }
	    
	    @ExceptionHandler(ValidationException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public Map<String, String> handleValidationException(ValidationException ex) {
	        return ex.getErrors();
	    }

}
