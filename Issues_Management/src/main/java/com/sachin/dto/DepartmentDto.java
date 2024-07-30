package com.sachin.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Department_Table")
public class DepartmentDto {
	
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int d_id;
	
	@Column(name="Department_Type")
	private String d_type;
	
	@Column(name="Department_Area")
	private String area;
	
	@Column(name="Department_Address")
	private String address;

}
