package com.sachin.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sachin.dto.Images;
import com.sachin.dto.RegisterDto;
import com.sachin.repository.Imagerepo;
import com.sachin.repository.Repository;
import com.sachin.service.DtoServiceImpl;
@Controller
public class FileUploadController {
	@Autowired
	private Repository userrepo;
	@Autowired
	private DtoServiceImpl dtoServiceImpl;
	@Autowired
	private Imagerepo imagerepo; 
	
	@RequestMapping("/edituser")
	public String edituser(@RequestParam int id, Model model) {
		System.out.println("editing.....");
		RegisterDto returnuser = dtoServiceImpl.getuserbyid(id);
		model.addAttribute("dto", returnuser);
		System.out.println(returnuser);
		return "EditUser";
	}
	
	@RequestMapping("/viewuser")
	public String viewUser(@RequestParam int id, Model model) {
		System.out.println("viewing.....");
		RegisterDto ret = dtoServiceImpl.getuserbyid(id);
		List<RegisterDto> returnuser= new ArrayList<RegisterDto>();
		returnuser.add(ret);
		model.addAttribute("stulist", returnuser);
		model.addAttribute("dto",ret);
		System.out.println(returnuser);
		return "Home";
	}
	
	
	@RequestMapping("/passwordReset")
	public String restpassword(@RequestParam int id, Model model) {
		System.out.println("Resetting.....");
		RegisterDto returnuser = dtoServiceImpl.getuserbyid(id);
		model.addAttribute("dto", returnuser);
		System.out.println(returnuser);
		return "PasswordReset";
	}
	
	
	
	
	@RequestMapping("/Update")
	public String handleFileUpload(@RequestParam MultipartFile file,@ModelAttribute("registerdto") RegisterDto registerdto,
			Model model,HttpSession session,Images image) {
		System.out.println("Updating........");
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload.");
			return "EditUser";
		}
		
		try {
			
			
// Save the file to the specified directory
			 String originalFilename =registerdto.getFirstName()+ file.getOriginalFilename();
	         String newFilename =  originalFilename;
			byte[] bytes = file.getBytes();
			Path path = Paths.get("E:/uploading/"+ "/" + newFilename);
			System.out.println(path);
			Files.write(path, bytes);
	List<Images> opt=imagerepo.getbyuserid(registerdto.getId());
	if(opt!=null) {
		
		
		for(Images dto:opt) {
			System.out.println(dto.getUserid());
		//	imagerepo.update(dto.getUserid());
			dto.setImagestatus("InActive");
			imagerepo.save(dto);
		}
			
			image.setImagestatus("Active");
			image.setImagename(newFilename);
			image.setImagesize(file.getSize());
			image.setImagetype(file.getContentType());
			image.setImageuploadedate(LocalDateTime.now());
			image.setImageuploadedby(registerdto.getFirstName());
			image.setUserid(registerdto.getId());
			Optional<RegisterDto> Optuser= userrepo.getbyemail(registerdto.getEmail());
			RegisterDto usr=Optuser.get();
			
			System.out.println(usr);
			usr.setProfileImage(newFilename);
			userrepo.save(usr);
			imagerepo.save(image);
			System.out.println("updating image data.........");
			System.out.println(usr);
				
			}else{
			
			image.setImagestatus("Active");
			image.setImagename(newFilename);
			image.setImagesize(file.getSize());
			image.setImagetype(file.getContentType());
			image.setImageuploadedate(LocalDateTime.now());
			image.setImageuploadedby(registerdto.getFirstName());
			image.setUserid(registerdto.getId());
			Optional<RegisterDto> Optuser= userrepo.getbyemail(registerdto.getEmail());
			RegisterDto usr=Optuser.get();
			System.out.println(usr);
			System.out.println("saving......image data");
			usr.setUpdatedBy(registerdto.getFirstName());
			usr.setUpdatedDate(LocalDate.now());
			usr.setProfileImage(newFilename);
			usr.setFirstName(registerdto.getFirstName());
			usr.setLastName(registerdto.getLastName());
			userrepo.save(usr);
			imagerepo.save(image);
			System.out.println(registerdto);
		//	dtoServiceImpl.RegisterUser(registerdto);
			System.out.println(usr);
				
			
}

			model.addAttribute("message", "You successfully uploaded " + "X-workz" + file.getOriginalFilename() + "'");
//			String imageUrl = "/uploading/" + newFilename;
//            session.setAttribute("profileImage", imageUrl);
			//     model.addAttribute("dto", registerdto);
            model.addAttribute("image", image);
	
	} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "File upload failed!");
		}

		return "Login";
	}
}
