package com.imaginnovate.tms.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.tms.exception.EmployeeNotFoundException;
import com.imaginnovate.tms.model.EmployeeDto;
import com.imaginnovate.tms.model.EmployeeEntity;
import com.imaginnovate.tms.model.EmployeeResponse;
import com.imaginnovate.tms.model.EmployeeTaxCalculator;
import com.imaginnovate.tms.model.EmployeeTaxCalculatorResponse;
import com.imaginnovate.tms.repository.EmployeeTaxManagementRepository;
import com.imaginnovate.tms.utils.EmployeeResponseBuilder;
import com.imaginnovate.tms.utils.TaxCalculationUtils;

/**
 * @author Avishek Mahakud
 * 
 */

@Service
public class EmployeeTaxManagementServiceImpl implements EmployeeTaxManagementService {

	@Autowired
	EmployeeTaxManagementRepository repository;

	@Override
	public EmployeeResponse saveEmployee(EmployeeDto employeeDto) {
		EmployeeEntity entity = repository.save(
				EmployeeEntity.build(0, employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(),
						employeeDto.getPhoneNumbers(), employeeDto.getDoj(), employeeDto.getSalary()));

		return EmployeeResponseBuilder.buildApiResponse(List.of(entity),
				Map.of("successMessage", "Employee got saved successfully with id : " + entity.getId()), true);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {

		return repository.findAll();
	}

	@Override
	public EmployeeTaxCalculatorResponse calculateTax() {

		List<EmployeeEntity> employees = getAllEmployees();

		if ((Objects.nonNull(employees) && !employees.isEmpty())) {

			List<EmployeeTaxCalculator> response = employees.stream().map(employee -> {

				EmployeeTaxCalculator calculator = EmployeeTaxCalculator.build(employee.getId(),
						employee.getFirstName(), employee.getLastName(),
						TaxCalculationUtils.calculateYearlySalary(employee), TaxCalculationUtils.calculateTax(employee),
						TaxCalculationUtils.calculateCess(employee));
				return calculator;
			}).toList();

			return EmployeeTaxCalculatorResponse.build(response, Map.of(), true);

		} else {
			throw new EmployeeNotFoundException("No employee found");
		}

	}

}
