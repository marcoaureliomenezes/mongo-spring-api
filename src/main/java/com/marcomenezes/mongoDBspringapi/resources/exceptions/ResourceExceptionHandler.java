package com.marcomenezes.mongoDBspringapi.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcomenezes.mongoDBspringapi.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	HttpStatus status = HttpStatus.NOT_FOUND;
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(
			ObjectNotFoundException e, 
			HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), 
												status.value(), "Não encontrado", 
												e.getMessage(), 
												request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
