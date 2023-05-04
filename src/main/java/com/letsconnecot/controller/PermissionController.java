package com.letsconnecot.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.letsconnecot.dto.PermissionDto;
import com.letsconnecot.model.Employee;
import com.letsconnecot.model.Permissions;
import com.letsconnecot.repository.EmployeeRepository;
import com.letsconnecot.repository.PermissionRepository;

@RestController
@RequestMapping(name = "/permission")
public class PermissionController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@PostMapping("/set/{role}/{id}")
	public Set<Permissions> setPermission(@PathVariable("role") String roles, @PathVariable("id") Integer id,
			Set<PermissionDto> permissions) {
		Optional<Employee> findById = employeeRepository.findById(id);
		Set<Permissions> permission = new HashSet<>();
		if (!findById.isEmpty()) {
			Employee employee = findById.get();

			for (PermissionDto permissions2 : permissions) {
				permission.add(new Permissions(permissions2.getName(), employee));
			}

			permission.stream().forEach(e -> permissionRepository.save(e));
		}
		return permission;
	}
	
	@DeleteMapping("/delete/{empId}")
	public void deletePermissionByEmpId(@PathVariable("empId") Integer empId) {
		
	permissionRepository.deletePermissionByEmployeeId(empId);
	}

}
