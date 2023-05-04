package com.letsconnecot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letsconnecot.model.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    @Query(value = "SELECT * FROM employee WHERE  email= :email ", nativeQuery = true)
    public Optional<Employee> findByEmail(String email);


}
