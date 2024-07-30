package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.dto.DepartmentAdmin;

@Repository
public interface DepartmentAdminRepo extends JpaRepository<DepartmentAdmin, Integer> {
	@Query("select u from DepartmentAdmin u where u.email=:email")
	DepartmentAdmin searchByEmail(@Param("email") String email);

	@Query("select u from DepartmentAdmin u where u.phone=:phone")
	DepartmentAdmin searchByPhone(@Param("phone") Long phone);
	
	@Query("select u from DepartmentAdmin u where u.email=:email and u.password=:password and u.department=:department")
	DepartmentAdmin searchByEmailPassDept(@Param("email") String email ,@Param("password")String phone ,@Param("department")String department);

}
