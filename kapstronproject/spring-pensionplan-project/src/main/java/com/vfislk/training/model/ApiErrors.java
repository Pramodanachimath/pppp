package com.vfislk.training.model;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrors {

	LocalDateTime timeStamp;
	String message;
	int status;
	List<String> errors;

	public ApiErrors() {
		super();
	}

	public ApiErrors(LocalDateTime timeStamp, String message, int status, List<String> errors) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;
		this.errors = errors;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ApiErrors [timeStamp=" + timeStamp + ", message=" + message + ", status=" + status + ", errors="
				+ errors + "]";
	}

}
