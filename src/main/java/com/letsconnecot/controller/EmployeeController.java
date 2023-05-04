package com.letsconnecot.controller;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsconnecot.dto.EmployeeRequestDto;
import com.letsconnecot.dto.EmployeeResponseDto;
import com.letsconnecot.model.Employee;
import com.letsconnecot.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/add")
	ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto requestDto) {
		  EmployeeResponseDto employee = employeeService.createEmployee(requestDto);
		return new ResponseEntity<EmployeeResponseDto>(employee, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	ResponseEntity<List<EmployeeResponseDto>> getEmployees() {
		List<EmployeeResponseDto> employeeResponseDto = employeeService.getEmployee();
		return new ResponseEntity<List<EmployeeResponseDto>>(employeeResponseDto, HttpStatus.OK);
	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<EmployeeResponseDto> getItem(@PathVariable("empId") Integer empId) {
		EmployeeResponseDto responseDto = employeeService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeResponseDto>(responseDto, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<EmployeeResponseDto> updateEmployeeDetailes(@PathVariable("empId") Integer empId,
			EmployeeRequestDto requestDto) {
		EmployeeResponseDto updateEmployee = employeeService.updateEmployee(requestDto, empId);
		return new ResponseEntity<EmployeeResponseDto>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<EmployeeResponseDto> removeItem(@PathVariable("empId") Integer empId) {

		EmployeeResponseDto responseDto = employeeService.deleteEmployee(empId);
		return new ResponseEntity<EmployeeResponseDto>(responseDto, HttpStatus.ACCEPTED);

	}

}
