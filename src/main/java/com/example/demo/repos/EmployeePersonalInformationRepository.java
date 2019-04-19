package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.EmployeePersonalInformation;

public interface EmployeePersonalInformationRepository
	extends JpaRepository<EmployeePersonalInformation, Long>{
	
	
	
}
