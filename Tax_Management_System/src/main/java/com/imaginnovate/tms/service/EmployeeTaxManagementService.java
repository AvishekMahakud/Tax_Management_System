package com.imaginnovate.tms.service;

import java.util.List;

import com.imaginnovate.tms.model.EmployeeDto;
import com.imaginnovate.tms.model.EmployeeEntity;
import com.imaginnovate.tms.model.EmployeeResponse;
import com.imaginnovate.tms.model.EmployeeTaxCalculatorResponse;

public interface EmployeeTaxManagementService {
	
	public EmployeeResponse saveEmployee(EmployeeDto employeeDto);

    public List<EmployeeEntity> getAllEmployees();

    public EmployeeTaxCalculatorResponse calculateTax();

}
