package com.fjtechsoultions.BootCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fjtechsoultions.BootCrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
