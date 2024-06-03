package com.imaginnovate.tms.controller;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imaginnovate.tms.exception.EmployeeNotFoundException;
import com.imaginnovate.tms.model.EmployeeEntity;
import com.imaginnovate.tms.model.EmployeeResponse;
import com.imaginnovate.tms.utils.EmployeeResponseBuilder;

/**
 * @author Avishek Mahakud
 * 
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final String ERROR_MESSAGE = "errorMessage";

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {

		return new ResponseEntity<>(EmployeeResponseBuilder.buildApiResponse(new ArrayList<EmployeeEntity>(),
				Map.of(ERROR_MESSAGE, exception.getMessage()), false), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<EmployeeResponse> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<String, String>();

		exception.getBindingResult().getFieldErrors().forEach(error -> {

			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return new ResponseEntity<>(
				EmployeeResponseBuilder.buildApiResponse(new ArrayList<EmployeeEntity>(), errorMap, false),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<EmployeeResponse> handleDateTimeParseException(DateTimeParseException exception) {

		return new ResponseEntity<>(EmployeeResponseBuilder.buildApiResponse(new ArrayList<EmployeeEntity>(),
				Map.of("doj", "doj must be in dd/mm/yyyy format"), false), HttpStatus.NOT_FOUND);

	}

}
