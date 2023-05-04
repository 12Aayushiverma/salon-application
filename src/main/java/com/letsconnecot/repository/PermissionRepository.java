package com.letsconnecot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.letsconnecot.model.Permissions;
@Repository
public interface PermissionRepository extends JpaRepository<Permissions,Integer> {

	@Query(value = "SELECT permission_name FROM security.permissions where employee_id= :id", nativeQuery = true)
	List<String> getPermissionData(@Param("id") Integer id);
	@Transactional
	@Modifying
	@Query(value = "DELETE  FROM security.permissions where employee_id= :eId", nativeQuery = true)
	Integer deletePermissionByEmployeeId(@Param("eId") Integer eId);
	}
