package com.sachin.controller;

import java.beans.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.dto.ComplaintsDto;
import com.sachin.dto.DepartmentAdmin;
import com.sachin.dto.DepartmentDto;
import com.sachin.dto.RegisterDto;
import com.sachin.repository.DepartmentAdminRepo;
import com.sachin.repository.DepartmentRepo;
import com.sachin.service.ComplaintsServiceImpl;
import com.sachin.service.DepartmentAdminServiceImpl;
import com.sachin.util.PasswordGenerator2;

@Controller
public class DepartmentAdminController {
	@Autowired
	private DepartmentAdminServiceImpl departmentAdminServiceImpl;
	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl;
	@Autowired
	private DepartmentRepo departmentrepo;
	@Autowired
	private DepartmentAdminRepo departmentAdminRepo;
	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping("/createdepartmentadmin")
	public String saveDepartmentDto(@ModelAttribute("departmentAdmin") DepartmentAdmin departmentAdmin, Model model) {
		System.out.println(departmentAdmin);
		departmentAdminServiceImpl.save_and_sendemail(departmentAdmin);
		model.addAttribute("message",
				"DepartmentAdmin Access Created Succesfully and login sent to DepartmentAdmin email.");
		return "AdminHome";

	}

	@RequestMapping("/logindepartmentadmin")
	public String departmentAdminLogin(@ModelAttribute("admin") DepartmentAdmin admin,Model model) {
		System.out.println(admin);
	 DepartmentAdmin exists=departmentAdminServiceImpl.checkemailpassdept(admin);
	 if(exists!=null) {
		 model.addAttribute("admin", exists);
		 model.addAttribute("message","Logged in successfully.....");
		 return "DepartmentAdminHome";
	 }else {
		 
		 model.addAttribute("msg1","Could not Log in Please try again with Correct Credentials .....");
		 return"DepartmentAdminLogin";
	 }
		
	}
	
	@RequestMapping("/viewalldepartmentcomplaints")
	public ModelAndView registeredComplaints(@RequestParam("department") String department) {
		System.out.println("viewing all complaints......");
		ModelAndView mv = new ModelAndView();
		//List<ComplaintsDto> allcomplaints = complaintsServiceImpl.getallusers();
		List<DepartmentDto> alldepartments= departmentrepo.findAll();
		List<ComplaintsDto> viewalldeptcomplaints = complaintsServiceImpl.getAllComplaintsBasedOnType(department);
		System.out.println(alldepartments);
		//mv.addObject("departmentlist", alldepartments);
		//mv.addObject("department",new DepartmentDto());
		mv.addObject("stulist", viewalldeptcomplaints);
		//mv.addObject("stulist", allcomplaints);
		mv.setViewName("ViewAllComplaints");
		return mv;
	}
	
	@RequestMapping("/forgotpassword")
    public String forgotPassword(@RequestParam String email, Model model)
    {
        DepartmentAdmin departmentAdmin=departmentAdminRepo.searchByEmail(email);
        if(departmentAdmin!=null)
        {
        	String password = PasswordGenerator2.generatePassword();
        	String encodedpassword	=encoder.encode(password);
        	System.out.println(encodedpassword);
        	departmentAdmin.setPassword(encodedpassword);
           departmentAdminServiceImpl.update(departmentAdmin);
           departmentAdminServiceImpl.sendEmail(departmentAdmin,password);
            System.out.println("new password sent to registered mail id"+password);
            model.addAttribute("msg","A Temporary password has been sent to registered mail id login with that password and reset New password");	      
            return "DepartmentAdminLogin";

        }
        else {
            System.out.println("new password not generated");
            model.addAttribute("msg","please enter registered email id");
            return "DepartmentAdminForgotPassword";
        }

    }
	
}
