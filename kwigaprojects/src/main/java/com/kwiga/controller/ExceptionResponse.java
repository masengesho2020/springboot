package com.kwiga.controller;

import java.time.ZonedDateTime;

public class ExceptionResponse {
	
	private String message;
	private int httpStatus;
	private ZonedDateTime time;
	
	public ExceptionResponse(String message, int httpStatus, ZonedDateTime time) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}
	
}
