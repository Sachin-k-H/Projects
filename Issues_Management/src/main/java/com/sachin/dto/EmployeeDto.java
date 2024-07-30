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
@Table(name="Employee_Table")
public class EmployeeDto {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Emplyoee ID")
	    private int e_id;

	    @Column(name = "Department_ID")
	    private int departmentId;

	    @Column(name = "Name")
	    private String name;

	    @Column(name = "Designation")
	    private String designation;

	    @Column(name = "Email")
	    private String email;

	    @Column(name = "Phone")
	    private Long phone;

	    @Column(name = "Password")
	    private String password;

}
