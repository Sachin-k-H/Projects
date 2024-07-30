package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.dto.EmployeeDto;

public interface EmplyoeeRepo extends JpaRepository<EmployeeDto, Integer>{
	

}
