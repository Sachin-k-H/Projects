package com.sachin.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sachin.dto.RegisterDto;
import com.sachin.service.DtoService;
import com.sachin.service.DtoServiceImpl;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	private DtoService dtoservice;
	
	@Autowired
	private DtoServiceImpl dtoServiceImpl;

	public RegisterController() {

		System.out.println("sign up controller created");
	}

	@PostMapping("/signupdata")
	public String signUp(@Valid RegisterDto registerdto, BindingResult bindingResult, Model model) {

		
		if (bindingResult.hasErrors()) {
	bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
			model.addAttribute("valid", bindingResult.getAllErrors());
			model.addAttribute("dto", registerdto);
			return "RegisterPage";
		} else {
	dtoservice.save(registerdto);
		//	dtoServiceImpl.RegisterUser(registerdto);
			System.out.println("sign up is success");
			System.out.println(registerdto);
			model.addAttribute("success", "your sign up is success :" + registerdto.getFirstName());
			return "RegisterPage";
		}

	}
}
