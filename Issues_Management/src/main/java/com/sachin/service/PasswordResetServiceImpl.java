package com.sachin.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.dto.PasswordResetDto;
import com.sachin.dto.RegisterDto;
import com.sachin.repository.PasswordResetRepo;
import com.sachin.repository.Repository;

@Service
public class PasswordResetServiceImpl  implements PasswordResetService{
	 @Autowired
	    private PasswordResetRepo passwordResetRepo;
	   
	    @Autowired
	    private Repository repository;
	    

	    @Override
	    public boolean updateUserPassword(PasswordResetDto passwordResetDto) {
	        Optional<RegisterDto> optional= repository.findEmailAndPass(passwordResetDto.getEmail(), passwordResetDto.getPassword());
	        if(optional.isPresent()) {
	            if (passwordResetDto.getNewpassword().equals(passwordResetDto.getConfirmpassword())) {
	            	RegisterDto obj= repository.searchByEmail(passwordResetDto.getEmail());
	            	obj.setUpdatedBy(obj.getFirstName());
	            	obj.setUpdatedDate(LocalDate.now());
	            	obj.setAccountLock(3);
	            	
	            	System.out.println(obj);
	            	repository.save(obj);
	                boolean result = passwordResetRepo.updateUserPassword(passwordResetDto);
	                if (result) {
	                    System.out.println("updated success fully");
	                    return true;
	                } else {
	                    System.out.println("not updated success fully");
	                    return false;
	                }
	            } else {
	                System.out.println("please confirm password correctly");
	                return false;
	            }
	        }
	        else {
	            System.out.println("email and password not valid");
	        }
	        return false;
	    }
	
}
