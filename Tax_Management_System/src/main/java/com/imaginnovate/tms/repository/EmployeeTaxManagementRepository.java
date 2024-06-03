package com.imaginnovate.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.tms.model.EmployeeEntity;

/**
 * @author Avishek Mahakud
 * 
 */

@Repository
public interface EmployeeTaxManagementRepository extends JpaRepository<EmployeeEntity, Integer> {

}
