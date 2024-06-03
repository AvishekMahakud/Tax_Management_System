package com.imaginnovate.tms.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Avishek Mahakud
 * 
 */

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	@ElementCollection
	@CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "phone_number")
	private List<String> phoneNumbers;

	private LocalDate doj;

	private Double salary;

}
