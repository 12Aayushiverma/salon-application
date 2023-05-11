package com.letsconnecot.dto;

import java.util.List;
import java.util.Set;

import com.letsconnecot.model.Permissions;

import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
	private Integer id;
	private String name;
	private String email;
	private String description;
	private String password;
	private String role;
	private List<String> permissions;
	
	
}
