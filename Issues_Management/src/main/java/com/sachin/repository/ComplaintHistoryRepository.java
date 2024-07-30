package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.dto.ComplaintHistory;

public interface ComplaintHistoryRepository extends JpaRepository<ComplaintHistory, Integer>{

}
