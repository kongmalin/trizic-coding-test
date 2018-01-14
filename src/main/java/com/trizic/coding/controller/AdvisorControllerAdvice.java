package com.trizic.coding.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trizic.coding.dto.ErrorResp;

@ControllerAdvice
public class AdvisorControllerAdvice extends ResponseEntityExceptionHandler {

	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return generateResponse("There is something wrong with the input.", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return generateResponse("The media type is not support.", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions() {
		return generateResponse("Server is not available for now.", HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<Object> generateResponse(String errorMessage, HttpStatus httpStatus) {
		ErrorResp respObject = new ErrorResp();
		respObject.setMessage(errorMessage);
		return new ResponseEntity<Object>(respObject, httpStatus);
	}

}
