package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employee;

public interface EmployeeRepository
    extends CrudRepository<Employee, Long> {
	
	@Query(value="SELECT u FROM Employee u WHERE u.lastName=?1")
	public List<Employee> findByLastName(String lastName);
	
}
