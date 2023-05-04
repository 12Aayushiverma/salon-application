package com.letsconnecot.service;

import com.letsconnecot.model.Permissions;

public interface PermissionService {
	
	public Permissions addPermission(Integer employeeId);
	
	public Integer deletePermissionByEmpId(Integer employeeId);
}
