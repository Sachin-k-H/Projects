package com.sachin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.dto.ComplaintsDto;
import com.sachin.dto.DepartmentAdmin;
import com.sachin.dto.DepartmentDto;
import com.sachin.dto.EmployeeDto;
import com.sachin.repository.DepartmentAdminRepo;
import com.sachin.repository.DepartmentRepo;
import com.sachin.repository.EmplyoeeRepo;
import com.sachin.service.ComplaintsServiceImpl;
import com.sachin.service.DepartmentAdminServiceImpl;
import com.sachin.service.EmployeeServiceImpl;
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
	@Autowired
	private EmplyoeeRepo employeerepo;
	@Autowired
	private HttpSession httpsession ;
	@Autowired
	private EmployeeServiceImpl employeeserviceimpl;
	

	@RequestMapping("/createdepartmentadmin")
	public String saveDepartmentDto(@ModelAttribute("departmentAdmin") DepartmentAdmin departmentAdmin, Model model) {
		System.out.println(departmentAdmin);
		DepartmentDto  deptdetails=departmentrepo.getDepartmentDetails(departmentAdmin.getDepartment());
		departmentAdmin.setDepartment_id(deptdetails.getD_id());
		departmentAdmin.setAccountLock(3);
		departmentAdminServiceImpl.save_and_sendemail(departmentAdmin);
		
		model.addAttribute("message",
				"DepartmentAdmin Access Created Succesfully and login sent to DepartmentAdmin email.");
		return "AdminHome";

	}

	@RequestMapping("/logindepartmentadmin")
	public String departmentAdminLogin(@ModelAttribute("admin") DepartmentAdmin admin,Model model,HttpServletRequest request) {
		System.out.println(admin);
		
	 DepartmentAdmin exists=departmentAdminServiceImpl.checkemailpassdept(admin);
	 if(exists!=null) {
	HttpSession session=	 request.getSession();
	//session.setAttribute("departmentdetails", exists);
	session.setAttribute("department", exists);
	session.setAttribute("admindepartment", exists.getDepartment());
		 exists.setAccountLock(3);
		 model.addAttribute("admin", exists);
		 model.addAttribute("message","Logged in successfully.....");
		 departmentAdminRepo.save(exists);
		 return "DepartmentAdminHome";
	 }else {
		 DepartmentAdmin exist=departmentAdminRepo.searchByEmail(admin.getEmail());
		 model.addAttribute("msg1","Could not Log in Please try again with Correct Credentials ....."+ "u have " + (exist.getAccountLock() - 1) + "attempts left");
		 exist.setAccountLock((exist.getAccountLock() - 1));
		 departmentAdminRepo.save(exist);
		 
		 if (exist.getAccountLock() == 0) {
				model.addAttribute("msg1", "Your Account has been locked due to 3 wrong attempts please do "
						+ "Forgot password to reset password and Login ");
				
				exist.setPassword(null);

				departmentAdminRepo.save(exist);

			return"DepartmentAdminLogin";	

		 }
		 
		 return"DepartmentAdminLogin";
	 }
		
	}
	
	@RequestMapping("/viewalldepartmentcomplaints")
	public ModelAndView registeredComplaints() {
		System.out.println(" viewing all complaints...... ");
		DepartmentAdmin department=(DepartmentAdmin)httpsession.getAttribute("department");
		ModelAndView mv = new ModelAndView();
		List<EmployeeDto> allemployees = employeerepo.getEmployeeList(department.getDepartment());
		String deptid= String.valueOf(department.getDepartment_id());
		List<ComplaintsDto> viewalldeptcomplaints = complaintsServiceImpl.getAllocatedComplaints(deptid);
		mv.addObject("employeelist", allemployees);
		mv.addObject("stulist", viewalldeptcomplaints);
		//mv.addObject("stulist", allcomplaints);
		mv.setViewName("ViewAllDepartmentComplaints");
		return mv;
	}
	
	@RequestMapping("/viewalldepartmentemployees")
	public ModelAndView viewemployeess() {
		DepartmentAdmin department=(DepartmentAdmin)httpsession.getAttribute("department");
		List<EmployeeDto> allemployees = employeerepo.getEmployeeList(department.getDepartment());
		ModelAndView mv = new ModelAndView();
		mv.addObject("stulist", allemployees);
		mv.setViewName("ViewAllDeptEmployees");
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
           departmentAdminServiceImpl.sendEmail1(departmentAdmin,password);
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
	
	@RequestMapping("/registeremployee")
	public String employeeRegisteration(@RequestParam("department") String department, Model model) {
	DepartmentDto	deptdetails=departmentrepo.getDepartmentDetails(department);
	model.addAttribute("EmployeeDeptid", deptdetails.getD_id());
	model.addAttribute("EmployeeDepartment", department);
		return"RegisterEmployee";
	}
	
	@RequestMapping("/createemployee")
	public String saveEmployeeRegisteration(@ModelAttribute("employeedto")EmployeeDto employeeDto ){
		employeeserviceimpl.save_And_sendEmail(employeeDto);
		return "EmployeeLogin";
	}
	
	@RequestMapping("/loginemployee")
	public String employeeLogin(@ModelAttribute("employee") EmployeeDto employeedto,Model model,HttpServletRequest request) {
		System.out.println(employeedto);
		
	EmployeeDto exists=employeeserviceimpl.checkemailpassdept(employeedto);
	 if(exists!=null) {
		 httpsession.setAttribute("employeedto", exists);
		 model.addAttribute("employee", exists);
		 model.addAttribute("message","Logged in successfully.....");
		 return "EmployeeHome";
	 }else {
		 model.addAttribute("msg1","Could not Log in Please try again with Correct Credentials .....");
			return"EmployeeLogin";	

		 }
		 
	
	}
	
	
	@RequestMapping("/viewallassingedcomplaints")
	public ModelAndView viewemployeeassingedcomplants() {
		EmployeeDto empdetails =(EmployeeDto)httpsession.getAttribute("employeedto");
		List<ComplaintsDto> assignedcomplaints= complaintsServiceImpl.getAllAssignedComplaints(empdetails.getE_id());
		ModelAndView mv = new ModelAndView();
		mv.addObject("stulist", assignedcomplaints);
		mv.setViewName("ViewAllAssignedComplaintsToEmployee");
		return mv;
	}
	
	@RequestMapping("/assignemployee")
	public  String changeStatus(@ModelAttribute("complaintsdto") ComplaintsDto complaintsdto, Model model) {
		ComplaintsDto  usercomplaint = complaintsServiceImpl.getComplaintid(complaintsdto.getId());
		System.out.println(usercomplaint);
System.out.println(complaintsdto);
			System.out.println(complaintsdto.getId());
			System.out.println(complaintsdto.getEmployeeid());
			System.out.println(complaintsdto.getStatus());
			usercomplaint.setStatus(complaintsdto.getStatus());
	usercomplaint.setEmployeeid(complaintsdto.getEmployeeid());
	complaintsServiceImpl.SaveComplaint(usercomplaint);
		model.addAttribute("message","changed status and allocated department");
		return "redirect:/viewalldepartmentcomplaints";
	
		}
	
	
	
	
}
