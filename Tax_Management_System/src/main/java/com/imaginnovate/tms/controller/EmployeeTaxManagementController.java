package com.imaginnovate.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.tms.model.EmployeeDto;
import com.imaginnovate.tms.model.EmployeeResponse;
import com.imaginnovate.tms.model.EmployeeTaxCalculatorResponse;
import com.imaginnovate.tms.service.EmployeeTaxManagementService;

import jakarta.validation.Valid;

/**
 * @author Avishek Mahakud
 * 
 */

@RestController
@RequestMapping("/tms/employee")
public class EmployeeTaxManagementController {

	@Autowired
	EmployeeTaxManagementService service;

	@PostMapping(path = "/register")
	public ResponseEntity<EmployeeResponse> saveEmployee(@Valid @RequestBody EmployeeDto employee) {
		EmployeeResponse response = service.saveEmployee(employee);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/calculate/tax/{id}")
	public ResponseEntity<EmployeeTaxCalculatorResponse> getEmployeeTaxForAnEmployee(@PathVariable(required = true) String id) {

		EmployeeTaxCalculatorResponse response = service.calculateTaxForAnEmployee(id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/calculate/tax")
	public ResponseEntity<EmployeeTaxCalculatorResponse> getEmployeeTaxForAllEmployees() {

		EmployeeTaxCalculatorResponse response = service.calculateTaxForAllEmployees();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
