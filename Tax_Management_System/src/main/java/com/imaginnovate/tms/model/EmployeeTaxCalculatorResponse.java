package com.imaginnovate.tms.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class EmployeeTaxCalculatorResponse {

	@JsonProperty("employees")
	private List<EmployeeTaxCalculator> calculators;
	private Map<String, String> messages;
	private Boolean success;

}
