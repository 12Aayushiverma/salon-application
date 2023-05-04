package com.letsconnecot;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.letsconnecot.model.Employee;
import com.letsconnecot.model.Permissions;
import com.letsconnecot.repository.EmployeeRepository;
import com.letsconnecot.repository.PermissionRepository;

@SpringBootApplication
public class LetsconnecotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LetsconnecotApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private RolesRepository  rolesRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
	//	System.out.println(permissionRepository.getPermissionData(11));
		//System.out.println(permissionRepository.deletePermissionByEmployeeId(5));
		
//		Employee employee = new Employee();
//
//		employee.setName("John");
//		employee.setRole("Employee");
//		employee.setEmail("John@gmail.com");
//		employee.setDescription("2 years of exp");
//		employee.setRole("Role_Employee");
//		employeeRepository.save(employee);
//		Set<Permissions> permissions = new HashSet<>();
//		permissions.add(new Permissions("Read", employee));
//		permissions.stream().forEach(e->permissionRepository.save(e));
//		
//		
//		Roles roles = new Roles();
//		roles.setName("admin");
//		
//		Permissions permissions = new Permissions();
//		permissions.setName("READ");
//		permissions.setRole(roles);
//		roles.getPermissions().add(permissions);
//		
//		rolesRepository.save(roles);
//		
//		
//		Employee employee = new Employee();
//
//        employee.setName("nasser");
//		employee.setEmail("nasser@gmail.com");
//		employee.setDescription("2 year exp");	
//		employeeRepository.save(employee);
//        
//       ArrayList<Permissions> per = new ArrayList<>();
//        per.add(permissions);
//        roles.setPermission(per);
//        
//       ArrayList<Roles> allroles = new ArrayList<>();
//       allroles.add(roles);
//       
//       employee.setRoles(allroles);
//       
//       rolesRepository.save(roles);
//       
//       System.out.println("working");
//       employeeRepository.save(employee);
//        
        
	}
}
