package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.dto.DepartmentDto;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentDto, Integer> {
	
	@Query("select c from DepartmentDto c where c.d_type=:d_type ")
	DepartmentDto getDepartmentDetails(@Param("d_type")String department);

}
