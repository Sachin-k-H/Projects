package com.sachin.dto;

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
@Table(name="Department_Admin")
public class DepartmentAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int da_id;
	private String department;
	private int department_id;
	private String username;
	private String password;
	private String email;
	private long phone;
	
}
