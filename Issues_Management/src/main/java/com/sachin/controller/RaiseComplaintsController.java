package com.sachin.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sachin.dto.ComplaintsDto;
import com.sachin.dto.RegisterDto;
import com.sachin.service.ComplaintsServiceImpl;
import com.sachin.service.DtoServiceImpl;

@Controller
public class RaiseComplaintsController {
	@Autowired
	private DtoServiceImpl dtoServiceImpl;
	@Autowired
	private ComplaintsServiceImpl complaintsServiceImpl;
	
	@RequestMapping("/raiseComplaints")
	public String RaiseComplaints(@RequestParam int p, Model model) {
		System.out.println("Raising Complaint.....");
		RegisterDto ret = dtoServiceImpl.getuserbyid(p);
		
		model.addAttribute("dto",ret);
		
		return "Home";

}
	@RequestMapping("/saveComplaint")
	public String saveComplaints(@ModelAttribute("complaintsdto") ComplaintsDto complaintsdto,Model model,HttpSession session) {
		System.out.println("Saving Complaint.....");
		RegisterDto user= (RegisterDto)session.getAttribute("user");
		System.out.println(user.getId());
		RegisterDto ret = dtoServiceImpl.getuserbyid(user.getId());
		
		complaintsdto.setStatus("Active");
	complaintsdto.setUserid(ret.getId());
	complaintsdto.setCreatedBy(ret.getFirstName()+ret.getLastName());
	complaintsdto.setCreatedDateTime(LocalDateTime.now());
	complaintsServiceImpl.SaveComplaint(complaintsdto);
		model.addAttribute("dto",ret);
		model.addAttribute("msg","Complaint Raised Succesfully .We will initiate Resolution Mechanism Soon.  ");
				return "Home";
	
	
}
	@RequestMapping("/viewcomplaints")
	public String viewComplaints(@RequestParam int userid, Model model ) {
		System.out.println("Viewing Complaints..... ");
		List<ComplaintsDto> cid= complaintsServiceImpl.getuserid(userid);
		System.out.println(cid);
		model.addAttribute("stulist", cid);
   RegisterDto ret = dtoServiceImpl.getuserbyid(userid);
		model.addAttribute("dto",ret);
		return "Home";
		
		
	}
	@RequestMapping("/editcomplaint")
	public String edituser(@RequestParam int d, Model model) {
		System.out.println("editing.....");
		System.out.println(d);
		ComplaintsDto returnuser = complaintsServiceImpl.getComplaintid(d);
		model.addAttribute("Cdto", returnuser);
		System.out.println(returnuser);
		return "EdituserComplaint";
	}
	@RequestMapping("/updatecomplaint")	
	public String updat(@RequestParam int complaintId,@RequestParam String description,ComplaintsDto complaintsDto, Model model,HttpSession session) {
		System.out.println("updating...");
		ComplaintsDto updatedesc= complaintsServiceImpl.getComplaintid(complaintId);
		updatedesc.setDescription(description);
		complaintsServiceImpl.SaveComplaint(updatedesc) ;
		model.addAttribute("msg2"," Edited Complaint and submitted");
		RegisterDto user= (RegisterDto)session.getAttribute("user");
		System.out.println(user.getId());
		RegisterDto ret = dtoServiceImpl.getuserbyid(user.getId());
		model.addAttribute("dto",ret);
		return "Home";
	}
	
}
