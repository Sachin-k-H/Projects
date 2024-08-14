package com.sachin.service;

import com.sachin.dto.EmployeeDto;

public interface EmployeeService {
	

	void sendEmail2(EmployeeDto employeedto,String password);
	EmployeeDto checkemailpassdept(EmployeeDto employeedto);
	EmployeeDto save_And_sendEmail(EmployeeDto employeedto) ;
		
		
	
}
