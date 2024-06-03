package com.imaginnovate.tms.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class EmployeeDto {

	@NotBlank(message = "First Name is mandatory.")
	private String firstName;

	@NotBlank(message = "Last Name is mandatory.")
	private String lastName;

	@NotBlank(message = "email must not be null. It's mandatory.")
	@Email(message = "Invalid email entered")
	private String email;

	@NotEmpty(message = "At least one phone number is required.")
	private List<@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits.") String> phoneNumbers;

	@NotNull(message = "doj must not be null. It's mandatory.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate doj;

	@NotNull(message = "salary must not be null. It's mandatory.")
	@Min(value = 0, message = "Salary must be in positive.")
	private Double salary;

}
