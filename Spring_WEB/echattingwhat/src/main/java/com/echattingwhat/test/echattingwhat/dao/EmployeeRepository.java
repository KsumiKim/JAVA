package com.echattingwhat.test.echattingwhat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echattingwhat.test.echattingwhat.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
	public List<Employee> findAllByOrderByFirstNameAsc();
}
