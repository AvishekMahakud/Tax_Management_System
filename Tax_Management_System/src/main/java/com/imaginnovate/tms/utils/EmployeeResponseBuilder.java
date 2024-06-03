package com.imaginnovate.tms.utils;

import java.util.List;
import java.util.Map;

import com.imaginnovate.tms.model.EmployeeEntity;
import com.imaginnovate.tms.model.EmployeeResponse;

/**
 * @author Avishek Mahakud
 * 
 */

public class EmployeeResponseBuilder {

	public static EmployeeResponse buildApiResponse(List<EmployeeEntity> employees, Map<String, String> messageMap,
			Boolean success) {

		return EmployeeResponse.build(employees, messageMap, success);

	}

}
