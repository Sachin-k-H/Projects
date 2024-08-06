package com.sachin.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Complaints_Table")
public class ComplaintsDto {
	@Id
	@GeneratedValue
	@Column(name="Complaint_Id")
	private int id;
	@Column(name="Complaint_Type")
	private String type ;
	@Column(name="Complaint_Description")
	private String description;
	
	private String address;
	private String country;
	private String state;
	private String city;
	private int userid;
	private String createdBy;
	private LocalDateTime createdDateTime;
	private String status;
	private String department;
	private String employeeid;
}
