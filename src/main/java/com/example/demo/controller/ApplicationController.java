package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeRepository;

@RestController
public class ApplicationController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(
			method=RequestMethod.POST,
			value="/addEmployee")
	public String addNewEmployee(
			@RequestParam String firstName, 
			@RequestParam String lastName
			) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employeeRepository.save(employee);
		return "Saved!";
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/allEmployees")
	public Collection<Employee> getAllEmployees() {
		return (Collection<Employee>) employeeRepository
				.findAll();
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/byLastName/{lastName}"
			)
	public List<Employee> getUserByLastName(
			@PathVariable("lastName") String lastName
			) {
		System.out.println("Querying for matches to: "
			+ lastName);
		return employeeRepository
				.findByLastName(lastName);
	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			value="/testEndpoint"
			)
	public String testingHeaders(@RequestHeader(value="myHeader", required=true) String myHeader) {
		return "all good, brah.";
	}
}
