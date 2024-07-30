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
@Table(name="ComplaintHistory_Table")
public class ComplaintHistory  {
	@Id
	@GeneratedValue
	private int historyid;
	
	
	@Column(name="Complaint_Id")
	private int Cid;
	@Column(name="Complaint_Type")
	private String type ;
	@Column(name="Complaint_Description")
	private String description;
	
	private String updatedBy;
	private LocalDateTime updatedDateTime;
	
	private String status;
	private String department;
	
}
