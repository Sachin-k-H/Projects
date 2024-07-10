package com.sachin.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name="Admin_Details")
public class Admin {
	@Id
	private int id;
	private String username;
	private String password;
	private String email;
	private long phone;
	

}
