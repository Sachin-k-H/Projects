package com.sachin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sachin.dto.Admin;
import com.sachin.dto.RegisterDto;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<RegisterDto, Integer>{
	
	@Query("select u from RegisterDto u where u.email=:email")
	RegisterDto searchByEmail(@Param("email") String email );

	@Query("select u from RegisterDto u where u.phone=:phone")
	RegisterDto searchByPhone(@Param("phone") Long phone );
	
	@Query("select u from RegisterDto u where u.email=:email and u.password=:password ")
	RegisterDto searchbyemailandpassword(@Param("email") String email,@Param("password") String pass );
	
	@Query("select u from RegisterDto u where u.email=:email")
	RegisterDto searchEmail(@Param("email") String email );
	
	@Query("select u from RegisterDto u where u.phone=:phone")
	Optional<RegisterDto> searchPhone(@Param("phone") Long phone );
	
	@Query("select u from RegisterDto u where u.email=:email and  u.password=:password")
	Optional<RegisterDto> findByEmailAndPass(@Param ("email") String email,@Param ("password") String
	 pass);
	@Query("select u from RegisterDto u where u.email=:email and  u.password=:password")
	Optional<RegisterDto> findEmailAndPass(@Param ("email") String email,@Param ("password") String
	 pass);
	
	@Query("select u from RegisterDto u where u.email=:email and  u.password=:password")
	RegisterDto getEmailAndPass(@Param ("email") String email,@Param ("password") String
	 pass);
	

	@Query("select u from RegisterDto u where u.email=:email")
	Optional<RegisterDto> getbyemail(@Param("email") String email );
	
	@Query("select u from Admin u where u.email=:email and u.password=:password")
	 Admin findByEmailAndPassword(@Param ("email") String email,@Param ("password") String
	 pass);
	@Query("select u from Admin u where u.email=:email")
	Admin searchbyEmail(@Param("email") String email );
	
}
