package com.letsconnecot.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsconnecot.Exception.EmployeeException;
import com.letsconnecot.dto.EmployeeRequestDto;
import com.letsconnecot.dto.EmployeeResponseDto;
import com.letsconnecot.dto.PermissionDto;
import com.letsconnecot.model.Employee;
import com.letsconnecot.model.Permissions;
import com.letsconnecot.repository.EmployeeRepository;
import com.letsconnecot.repository.PermissionRepository;
import com.letsconnecot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private RolesRepository rolesRepository;
//	
	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeResponseDto createEmployee(EmployeeRequestDto emp) {

		Employee employee = new Employee();

		employee.setName(emp.getName());
		employee.setEmail(emp.getEmail());
		employee.setDescription(emp.getDescription());
		employee.setPassword(emp.getPassword());
		employee.setRole(emp.getRole());
		Employee saveEmp = employeeRepository.save(employee);
		Set<Permissions> permissions = new HashSet<>();
		permissions.add(new Permissions("Read", employee));
		permissions.stream().forEach(e -> permissionRepository.save(e));

		// Set<PermissionDto> permissionData =
		// permissionRepository.getPermissionData(employee.getId());
//	System.out.println(permissionData);

		return modelMapper.map(employee, EmployeeResponseDto.class);
	}

	@Override
	public List<EmployeeResponseDto> getEmployee() {

		List<Employee> employees = employeeRepository.findAll();
//		List<Permissions> findAll = permissionRepository.findAll();
		EmployeeResponseDto dto = new EmployeeResponseDto();
		if (!employees.isEmpty()) {
			List<EmployeeResponseDto> collect = employees.stream().map(emp -> {
				dto.setId(emp.getId());
				dto.setName(emp.getName());
				dto.setEmail(emp.getEmail());
				dto.setRole(emp.getRole());
				dto.setDescription(emp.getDescription());
				dto.setPassword(emp.getPassword());
				dto.setPermissions(permissionRepository.getPermissionData(emp.getId()));
				return dto;
			}).collect(Collectors.toList());
			return collect;

		} else {
			throw new EmployeeException("No Employee exists..");

		}

	}

	@Override
	public EmployeeResponseDto updateEmployee(EmployeeRequestDto emp, Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);

		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setId(employee.getId());
			employee.setName(emp.getName());
			employee.setEmail(emp.getEmail());
			employee.setDescription(emp.getDescription());
			employee.setPassword(emp.getPassword());
			employeeRepository.save(employee);
			return modelMapper.map(employee, EmployeeResponseDto.class);
		} else {
			throw new EmployeeException("No such employee found...");
		}
	}

	@Override
	public EmployeeResponseDto getEmployeeById(Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (!optional.isEmpty()) {
			return modelMapper.map(optional.get(), EmployeeResponseDto.class);
		} else {
			throw new EmployeeException("No employee found with this id" + id);
		}

	}

	@Override
	public EmployeeResponseDto deleteEmployee(Integer id) {

		Optional<Employee> opt = employeeRepository.findById(id);
		if (opt.isPresent()) {
			Employee employee = opt.get();
			permissionRepository.deletePermissionByEmployeeId(id);
			employeeRepository.deleteById(id);
			return modelMapper.map(employee, EmployeeResponseDto.class);
		} else {
			throw new EmployeeException("No Employee not found with this id " + id);
		}

	}

}
