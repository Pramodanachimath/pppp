package com.vfislk.training.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vfislk.training.model.ApiErrors;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "method not allowed");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);

		return ResponseEntity.status(status).headers(headers).body(errors);

	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Media not Supported");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "Path is not Supported");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Parameter not available");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		headers.add("error", "Data type missmatch");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		headers.add("error", "Servlet part is not available");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(ex.getMessage());
		errorMessage.add(request.getContextPath());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), status.value(), errorMessage);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@ExceptionHandler(value = PlanNotFoundException.class)
	public ResponseEntity<Object> handlePlanNotFound(PlanNotFoundException pe) {
//		String message = pe.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Plan Not Found");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(pe.getMessage());

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), pe.getMessage(), HttpStatus.CONFLICT.value(),
				errorMessage);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}

	@ExceptionHandler(value = AgentNotFoundExcepion.class)
	public ResponseEntity<Object> handleAgentNotFound(AgentNotFoundExcepion pe) {
//		String message = pe.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Agent Not Found");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(pe.getMessage());

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), pe.getMessage(), HttpStatus.CONFLICT.value(),
				errorMessage);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}

	@ExceptionHandler(value = CustomerNotFoundExcepion.class)
	public ResponseEntity<Object> handleCustomerNotFound(CustomerNotFoundExcepion pe) {
//		String message = pe.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Customer Not Found");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(pe.getMessage());

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), pe.getMessage(), HttpStatus.CONFLICT.value(),
				errorMessage);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}

	@ExceptionHandler(value = NomineeNotFoundExcepion.class)
	public ResponseEntity<Object> handleNomineeNotFound(NomineeNotFoundExcepion pe) {
//		String message = pe.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Nominee Not Found");
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(pe.getMessage());

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), pe.getMessage(), HttpStatus.CONFLICT.value(),
				errorMessage);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}

	@ExceptionHandler(value = Exception.class)
	ResponseEntity<Object> handleotherException(Exception e) {
//		String message = e.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Other Exception" + e.getMessage());
		List<String> errorMessage = new ArrayList<>();
		errorMessage.add(e.getMessage());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), e.getMessage(), HttpStatus.CONFLICT.value(),
				errorMessage);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);

	}

}
