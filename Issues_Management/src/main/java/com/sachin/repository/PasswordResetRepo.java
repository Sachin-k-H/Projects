package com.sachin.repository;

import com.sachin.dto.PasswordResetDto;

public interface PasswordResetRepo {
	 boolean updateUserPassword(PasswordResetDto passwordResetDto);
	 boolean updateDeptAdminPassword(PasswordResetDto passwordResetDto) ;
	 
}
