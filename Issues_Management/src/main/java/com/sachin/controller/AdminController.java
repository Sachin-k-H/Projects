package com.sachin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.dto.Admin;
import com.sachin.dto.ComplaintsDto;
import com.sachin.dto.DepartmentDto;
import com.sachin.dto.RegisterDto;
import com.sachin.repository.DepartmentRepo;
import com.sachin.service.ComplaintsServiceImpl;
import com.sachin.service.DtoServiceImpl;



@Controller
public class AdminController {
	@Autowired
	private DtoServiceImpl dtoServiceImpl;
	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl; 
	@Autowired
	private DepartmentRepo departmentrepo;
	
	@RequestMapping("/viewst")
	public ModelAndView registerusers(@ModelAttribute("admin") Admin admin,Model model) {
		ModelAndView mv = new ModelAndView();
		List<RegisterDto> allusers = dtoServiceImpl.getAllRegistereduser();
		mv.addObject("stulist", allusers);
		mv.setViewName("Viewst");
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
	
	
	@RequestMapping("/setstatus")
	public String changeuserstatus(@RequestParam int id, Model model) {
		System.out.println("setting status .....");
		System.out.println(id);
		RegisterDto user=dtoServiceImpl.getuserbyid(id);
		if(user.getAccountStatus().equalsIgnoreCase("active")) {
		user.setAccountStatus("Inactive");
		dtoServiceImpl.RegisterUser(user);
		} else if(user.getAccountStatus().equalsIgnoreCase("Inactive")) {
			user.setAccountStatus("Active");
			dtoServiceImpl.RegisterUser(user);
		}
		
		List<RegisterDto> allusers = dtoServiceImpl.getAllRegistereduser();
		model.addAttribute("stulist", allusers);
		
		return "AdminHome";
	}
	
	
	

	@RequestMapping("/adminlogin")
	public String getAdminLogin(@ModelAttribute("admin") Admin admin, Model model,HttpServletRequest request) {
		Admin returnuser= dtoServiceImpl.getadminemail(admin.getEmail());
		//System.out.println(returnuser);
		Admin admincred = dtoServiceImpl.getFirstemailpassword(admin.getEmail(), admin.getPassword());
		if (admincred != null) {
			System.out.println("logging in..");
			HttpSession httpSession = request.getSession();
			System.out.println(httpSession);
			httpSession.setAttribute("Admin", returnuser);
			System.out.println("admin username:"+returnuser.getUsername());
			
			return "AdminHome";
		} else {
			model.addAttribute("msg", " Wrong credentials...");
			return "Admin";
		}
	}
	
	@RequestMapping("/viewallcomplaints")
	public ModelAndView registeredComplaints() {
		System.out.println("viewing all complaints......");
		ModelAndView mv = new ModelAndView();
		List<ComplaintsDto> allcomplaints = complaintsServiceImpl.getallusers();
		List<DepartmentDto> alldepartments= departmentrepo.findAll();
		System.out.println(alldepartments);
		mv.addObject("departmentlist", alldepartments);
		mv.addObject("department",new DepartmentDto());
		mv.addObject("stulist", allcomplaints);
		mv.setViewName("ViewAllComplaints");
		return mv;
	}
	
	@RequestMapping("/search")
	public String SearchbyComplaintType(@ModelAttribute ComplaintsDto complaintsdto, Model model) {
		System.out.println(complaintsdto.getCity()+"-----"+complaintsdto.getType());
		if(complaintsdto.getType()!=""&&complaintsdto.getCity()=="") {
			System.out.println("entering only typesearch.....");
		List<ComplaintsDto> viewallcomplaints = complaintsServiceImpl.getAllComplaintsBasedOnType(complaintsdto.getType());

		System.out.println(viewallcomplaints);
		if (viewallcomplaints.isEmpty()) {
			model.addAttribute("message", "No Results Found .....");
			return "ViewAllComplaints";
		} else {
			model.addAttribute("stulist", viewallcomplaints);
			System.out.println("added");
			return "ViewAllComplaints";
		}
		}
		if(complaintsdto.getCity()!="" && complaintsdto.getType()=="") {
			System.out.println("entering only citysearch.....");
			List<ComplaintsDto> viewallcomplaints = complaintsServiceImpl.getAllComplaintsBasedOnCity(complaintsdto.getCity());

			System.out.println(viewallcomplaints);
			if (viewallcomplaints.isEmpty()) {
				model.addAttribute("message", "No Results Found .....");
				return "ViewAllComplaints";
			} else {
				model.addAttribute("stulist", viewallcomplaints);
				System.out.println("added");
				return "ViewAllComplaints";
			}
		}
		if(complaintsdto.getCity()!="" && complaintsdto.getType()!="") {
			System.out.println("entering both  type and citysearch.....");
			List<ComplaintsDto> viewallcomplaints = complaintsServiceImpl.getAllComplaintsBasedOnTypeandCity(complaintsdto.getType() ,complaintsdto.getCity());

			System.out.println(viewallcomplaints);
			if (viewallcomplaints.isEmpty()) {
				model.addAttribute("message", "No Results Found .....");
				return "ViewAllComplaints";
			} else {
				model.addAttribute("stulist", viewallcomplaints);
				System.out.println("added");
				return "ViewAllComplaints";
			}
			}else {
			model.addAttribute("message", "No Results Found .....");
			return "ViewAllComplaints";
			}
			
			
			
			
		}
		
		
		
		@RequestMapping("/searchcity")
		public String SearchbyComplaintCity(@RequestParam String city, Model model) {
			
			List<ComplaintsDto> viewallcomplaints = complaintsServiceImpl.getAllComplaintsBasedOnCity(city);

			System.out.println(viewallcomplaints);
			if (viewallcomplaints.isEmpty()) {
				model.addAttribute("message", "No Results Found .....");
				return "ViewAllComplaints";
			} else {
				model.addAttribute("stulist", viewallcomplaints);
				System.out.println("added");
				return "ViewAllComplaints";
			}

	}
		@RequestMapping("/changestatus")
		public  String changeStatus(@ModelAttribute("complaintsdto") ComplaintsDto complaintsdto, Model model) {
			ComplaintsDto  usercomplaint = complaintsServiceImpl.getComplaintid(complaintsdto.getId());
			System.out.println(usercomplaint);
	System.out.println(complaintsdto);
				System.out.println(complaintsdto.getId());
				System.out.println(complaintsdto.getStatus());
				System.out.println(complaintsdto.getDepartment());
				usercomplaint.setStatus(complaintsdto.getStatus());
		usercomplaint.setDepartment(complaintsdto.getDepartment());
		complaintsServiceImpl.SaveComplaint(usercomplaint);
			model.addAttribute("message","changed status and allocated department");
			return "redirect:/viewallcomplaints";
		
			}
				
@RequestMapping("/createdepartment")
public String saveDepartmentDto(@ModelAttribute("departmentDto") DepartmentDto departmentDto,Model model) {
	System.out.println(departmentDto);
	departmentrepo.save(departmentDto);
	model.addAttribute("message","Department Created Succesfully.......");
	return"AdminHome";
}
		
		
		
}
