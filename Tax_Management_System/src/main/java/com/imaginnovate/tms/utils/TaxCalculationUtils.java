package com.imaginnovate.tms.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import com.imaginnovate.tms.model.EmployeeEntity;

/**
 * @author Avishek Mahakud
 * 
 */

public class TaxCalculationUtils {

	private static final Double TAX_SLAB_1 = 250000.00;
	private static final Double TAX_SLAB_2 = 500000.00;
	private static final Double TAX_SLAB_3 = 1000000.00;
	private static final Double TAX_RATE_1 = 0.05;
	private static final Double TAX_RATE_2 = 0.10;
	private static final Double TAX_RATE_3 = 0.20;
	private static final Double CESS_RATE = 0.02;

	public static Double calculateCess(EmployeeEntity employee) {
		Double yearlySalary = calculateYearlySalary(employee);
		return yearlySalary > 2500000 ? (yearlySalary - 2500000) * CESS_RATE : 0.0;
	}

	public static Double calculateYearlySalary(EmployeeEntity employeeEntity) {

		LocalDate doj = employeeEntity.getDoj();

		Double monthlySalary = employeeEntity.getSalary();

		LocalDate startOfFinancialYear = LocalDate.of(doj.getYear(), Month.APRIL, 1);
		LocalDate endOfFinancialYear = LocalDate.of(doj.getYear() + 1, Month.MARCH, 31);

		long totalMonthsWorked = ChronoUnit.MONTHS.between(doj.withDayOfMonth(1), endOfFinancialYear.withDayOfMonth(1))
				+ 1;

		if (doj.isAfter(startOfFinancialYear) && doj.isBefore(endOfFinancialYear)) {
			long daysInMonthOfJoining = doj.lengthOfMonth();
			long daysWorkedInJoiningMonth = daysInMonthOfJoining - doj.getDayOfMonth() + 1;
			Double partialMonthSalary = (monthlySalary / daysInMonthOfJoining) * daysWorkedInJoiningMonth;
			totalMonthsWorked -= 1;
			return (monthlySalary * totalMonthsWorked) + partialMonthSalary;
		} else {
			return (monthlySalary * 12); // If DOJ is outside the financial year range
		}
	}

	public static Double calculateTax(EmployeeEntity employeeEntity) {

		Double yearlySalary = calculateYearlySalary(employeeEntity);
		Double tax = 0.0;

		if (yearlySalary <= TAX_SLAB_1) {
			tax = 0.0;
		} else if (yearlySalary <= TAX_SLAB_2) {
			tax = (yearlySalary - TAX_SLAB_1) * TAX_RATE_1;
		} else if (yearlySalary <= TAX_SLAB_3) {
			tax = (TAX_SLAB_2 - TAX_SLAB_1) * TAX_RATE_1 + (yearlySalary - TAX_SLAB_2) * TAX_RATE_2;
		} else {
			tax = (TAX_SLAB_2 - TAX_SLAB_1) * TAX_RATE_1 + (TAX_SLAB_3 - TAX_SLAB_2) * TAX_RATE_2
					+ (yearlySalary - TAX_SLAB_3) * TAX_RATE_3;
		}

		return tax;
	}

}
