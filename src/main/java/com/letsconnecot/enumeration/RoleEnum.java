package com.letsconnecot.enumeration;

public enum RoleEnum {

	 ADMIN("Admin"), EMPLOYEE("EMPLOYEE"), USER("User"),EDITOR("Editor");

	// declaring private variable for getting values
	private String role;

	// getter method
	public String getRole() {
		return this.role;
	}

	// enum constructor - cannot be public or protected
	private RoleEnum(String role) {
		this.role = role;
	}
}
