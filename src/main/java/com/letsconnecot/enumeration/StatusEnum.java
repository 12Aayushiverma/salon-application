package com.letsconnecot.enumeration;

public enum StatusEnum {

	PENDING("Pending"), SUBMITTED("Submitted"), APPROVED("Approved"), APPROVED_BY_Admin("Admin_Approved");

	// declaring private variable for getting values
	private String status;

	// getter method
	public String getStatus() {
		return this.status;
	}

	// enum constructor - cannot be public or protected
	private StatusEnum(String status) {
		this.status = status;
	}
}

