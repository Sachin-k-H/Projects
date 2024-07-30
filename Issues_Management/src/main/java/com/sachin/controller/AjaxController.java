package com.sachin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.dto.DepartmentAdmin;
import com.sachin.dto.RegisterDto;
import com.sachin.repository.DepartmentAdminRepo;
import com.sachin.repository.Repository;

@RestController
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private Repository repository;

	@Autowired
	private DepartmentAdminRepo departmentAdminRepo;

	@GetMapping("/checkEmail/{enteredemail}")
	public String CheckEmail(@PathVariable("enteredemail") String email) {
		RegisterDto optional = repository.searchByEmail(email);
		System.err.println(optional);
		if (optional != null) {
			return "Email Already Exists";

		} else {
			return "";
		}

	}

	@GetMapping("/checkPhone/{enteredphone}")
	public String CheckPhone(@PathVariable("enteredphone") Long phone) {
		Optional<RegisterDto> optional = repository.searchPhone(phone);
		System.err.println(optional);
		return optional.isPresent() ? "Phone already Exist" : "";
	}

	@GetMapping("/verifyEmail/{enteredemail}")
	public String VerifyEmail(@PathVariable("enteredemail") String email) {
		DepartmentAdmin optional = departmentAdminRepo.searchByEmail(email);
		System.err.println(optional);
		if (optional != null) {
			return "Email Already Exists";

		} else {
			return "";
		}
	}

	@GetMapping("/verifyPhone/{enteredphone}")
	public String VerifyPhone(@PathVariable("enteredphone") Long phone) {
		DepartmentAdmin optional = departmentAdminRepo.searchByPhone(phone);
		System.err.println(optional);

		if (optional != null) {
			return "Phone Already Exists";

		} else {
			return "";
		}

	}

}
