package com.sachin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.dto.ComplaintsDto;
@Repository
public interface ComplaintsRepo extends JpaRepository<ComplaintsDto, Integer>{
	@Query("select u from ComplaintsDto u where u.userid=:userid")
	List<ComplaintsDto> getbyuserid(@Param("userid") int userid);
	@Query("select u from ComplaintsDto u where u.type=:type")
	List<ComplaintsDto> getComplaintstype(@Param("type") String type);
	@Query("select u from ComplaintsDto u where u.city=:city")
	List<ComplaintsDto> getComplaintcity(@Param("city") String city);
	@Query("select u from ComplaintsDto u where u.type=:type and u.city=:city")
	List<ComplaintsDto> getComplainttypecity(@Param("city") String city,@Param("type") String type);

	@Query("select u from ComplaintsDto u where u.department=:department")
	List<ComplaintsDto> getAllocatedComplaints(@Param("department")String department);
	
	
	@Query("select u from ComplaintsDto u where u.employeeid=:employeeid")
	List<ComplaintsDto> getAllAssignedComplaints(@Param("employeeid")int employeeid);
}
