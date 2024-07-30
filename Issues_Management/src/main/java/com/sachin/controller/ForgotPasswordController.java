package com.sachin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sachin.dto.RegisterDto;
import com.sachin.repository.Repository;
import com.sachin.service.DtoServiceImpl;
import com.sachin.service.ForgotPasswordServiceImpl;
import com.sachin.util.PasswordGenerator2;

@Controller
@RequestMapping("/")
public class ForgotPasswordController {
	 @Autowired
	  private Repository repository;
	 @Autowired
	 private ForgotPasswordServiceImpl forgotPasswordServiceImpl;
	 @Autowired
		private DtoServiceImpl dtoServiceImpl;
	 
	 @Autowired
	 private PasswordEncoder encoder;
	 
	    public ForgotPasswordController()
	    {
	        System.out.println("forgot password created");
	    }
	@PostMapping("/forgot")
	    public String forgotPassword(@RequestParam String email, Model model)
	    {
	        RegisterDto registerdto=repository.searchByEmail(email);
	        if(registerdto!=null)
	        {
	        	String password = PasswordGenerator2.generatePassword();
	        	String encodedpassword	=encoder.encode(password);
	        	System.out.println(encodedpassword);
	        	registerdto.setPassword(encodedpassword);
	           forgotPasswordServiceImpl.updatepassword(registerdto);
	           dtoServiceImpl.sendEmail(registerdto,password);
	            System.out.println("new password sent to registered mail id"+password);
	            model.addAttribute("msg","A Temporary password has been sent to registered mail id login with that password and reset New password");	      
	            return "PasswordReset";

	        }
	        else {
	            System.out.println("new password not generated");
	            model.addAttribute("msg","please enter registered email id");
	            return "ForgotPassword";
	        }

	    }

}
