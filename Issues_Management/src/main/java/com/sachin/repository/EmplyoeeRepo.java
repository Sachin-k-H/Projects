package com.sachin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.dto.EmployeeDto;
@Repository
public interface EmplyoeeRepo extends JpaRepository<EmployeeDto, Integer>{
	@Query("select u from EmployeeDto u where u.email=:email")
	EmployeeDto getEmployeeByEmail (@Param("email") String email);
	
	@Query("select u from EmployeeDto u where u.phone=:phone")
	EmployeeDto getEmployeeByPhone (@Param("phone") Long email);
	
	@Query("select c from EmployeeDto c where c.department=:department")
	List<EmployeeDto> getEmployeeList (@Param("department")String department);

}
