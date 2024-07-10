package com.sachin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.dto.Admin;
import com.sachin.dto.RegisterDto;
import com.sachin.service.DtoServiceImpl;



@Controller
public class AdminController {
	@Autowired
	private DtoServiceImpl dtoServiceImpl;
	
	
	@RequestMapping("/viewst")
	public ModelAndView registerusers(@ModelAttribute("admin") Admin admin,Model model) {
		ModelAndView mv = new ModelAndView();
		List<RegisterDto> allusers = dtoServiceImpl.getAllRegistereduser();
		Admin returnuser= dtoServiceImpl.getadminemail(admin.getEmail());
		mv.addObject("admin",returnuser);
		mv.addObject("stulist", allusers);
		mv.setViewName("AdminHome");
		return mv;
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView Delete(@RequestParam int id, Model model) {
		System.out.println("Deleting .....");
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		dtoServiceImpl.deleteuser(id);
		List<RegisterDto> allusers = dtoServiceImpl.getAllRegistereduser();
		mv.addObject("stulist", allusers);
		mv.setViewName("Viewst");
		return mv;
	}
	
	

	@RequestMapping("/adminlogin")
	public String getAdminLogin(@ModelAttribute("admin") Admin admin, Model model) {
		/* System.out.println(user.getEmail() + user.getPassword()); */
		Admin returnuser= dtoServiceImpl.getadminemail(admin.getEmail());
		System.out.println(returnuser);
		Admin admincred = dtoServiceImpl.getFirstemailpassword(admin.getEmail(), admin.getPassword());
		if (admincred != null) {
			System.out.println("logging in..");
			model.addAttribute("admin",returnuser );
			return "AdminHome";
		} else {
			model.addAttribute("msg", " Wrong credentials...");
			return "Admin";
		}
	}
	
	
	
	

}
