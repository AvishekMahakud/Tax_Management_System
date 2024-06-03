package com.imaginnovate.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Avishek Mahakud
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class EmployeeTaxCalculator {

	Integer employeeCode;
	String firstName;
	String lastName;
	Double yearlySalary;
	Double taxAmount;
	Double cessAmount;
}
