package com.imaginnovate.tms.model;

import java.util.List;
import java.util.Map;

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
public class EmployeeResponse {

	private List<EmployeeEntity> employees;
	private Map<String, String> messages;
	private Boolean success;

}
