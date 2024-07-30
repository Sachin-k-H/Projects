package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachin.dto.DepartmentDto;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentDto, Integer> {

}
