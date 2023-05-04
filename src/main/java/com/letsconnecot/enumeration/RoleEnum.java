package com.letsconnecot.enumeration;

public enum RoleEnum {

	Manager("Manager"), ADMIN("Admin"), EMPLOYEE("EMPLOYEE");

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
