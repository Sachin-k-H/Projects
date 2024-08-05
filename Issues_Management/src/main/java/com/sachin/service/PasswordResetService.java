package com.sachin.service;

import com.sachin.dto.PasswordResetDto;

public interface PasswordResetService {
	 boolean updateUserPassword(PasswordResetDto passwordResetDto);
	  boolean updateDeptAdminPassword(PasswordResetDto passwordResetDto);
}
