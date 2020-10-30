package com.kwiga.Exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kwiga.controller.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object>handlingException(){
		HttpStatus httpStatus=HttpStatus.NOT_FOUND;
		ExceptionResponse exceptionResponse=new ExceptionResponse("Data Not Found", httpStatus.value(), ZonedDateTime.now());
		return new ResponseEntity<Object>(exceptionResponse,httpStatus);
	}
}
