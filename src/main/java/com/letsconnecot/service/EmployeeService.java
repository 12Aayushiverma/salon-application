package com.letsconnecot.service;

import java.util.List;
import java.util.Set;

import com.letsconnecot.dto.EmployeeRequestDto;
import com.letsconnecot.dto.EmployeeResponseDto;
import com.letsconnecot.model.Employee;

public interface EmployeeService {

	//create
	public EmployeeResponseDto createEmployee(EmployeeRequestDto emp);
	//get all Employee
	public List<EmployeeResponseDto> getEmployee();
	//update employee
	public EmployeeResponseDto updateEmployee(EmployeeRequestDto emp,Integer id);
	//get employee by id
	public EmployeeResponseDto getEmployeeById(Integer id);
	//Delete employee
	public EmployeeResponseDto deleteEmployee(Integer id);

}
