package com.sachin.service;

import java.util.List;
import java.util.Optional;

import com.sachin.dto.Admin;
import com.sachin.dto.RegisterDto;


public interface DtoService {
	 void RegisterUser(RegisterDto registerdto) ;
		 
	 default Optional<RegisterDto> save(RegisterDto registerdto){
			return Optional.empty();
		}
RegisterDto getemailndpassword(String email,String pass);
RegisterDto getemail(String email);
Optional<RegisterDto> getphone(RegisterDto registerdto);
RegisterDto getuserbyid(RegisterDto registerdto);
RegisterDto getuserbyid(int id);
Admin getFirstemailpassword(String email,String pass);
List<RegisterDto> getAllRegistereduser();
void deleteuser(int id);
Admin getadminemail(String email) ;
	
}

