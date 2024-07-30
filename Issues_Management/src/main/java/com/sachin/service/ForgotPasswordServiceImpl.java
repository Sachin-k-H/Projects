package com.sachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.dto.RegisterDto;
import com.sachin.repository.ForgotPasswordRepo;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	
	@Autowired
	private ForgotPasswordRepo forgotPasswordRepo;
	
	
	 @Override
	    public RegisterDto updatepassword(RegisterDto registerdto) {
		 RegisterDto registerdto1=forgotPasswordRepo.updatepassword(registerdto);
	        if (registerdto1!=null)
	        {
	            System.out.println("updated new password");
	            return registerdto1;
	        }
	        else {
	            System.out.println("not updated new password");
	            return null;
	        }
	    }

}
