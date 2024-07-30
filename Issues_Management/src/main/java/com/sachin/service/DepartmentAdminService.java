package com.sachin.service;

import com.sachin.dto.DepartmentAdmin;

public interface DepartmentAdminService {
	
	DepartmentAdmin save_and_sendemail(DepartmentAdmin departmentAdmin);
	
	DepartmentAdmin checkemailpassdept(DepartmentAdmin Admin);

}
