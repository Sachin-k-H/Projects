package com.sachin.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sachin.dto.RegisterDto;
import com.sachin.repository.Repository;
import com.sachin.service.DtoServiceImpl;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private DtoServiceImpl dtoServiceImpl;

	@Autowired
	private Repository repository;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/signindata")
	public String Login(@ModelAttribute("RegisterDto") RegisterDto registerdto, Model model,String password,
			HttpServletRequest request) {
		try {
			RegisterDto count = repository.searchByEmail(registerdto.getEmail());

            System.out.println("Account is:"+count.getAccountStatus());
            System.out.println(password+"|||"+count.getPassword());
            
            if(count.getAccountStatus().equalsIgnoreCase("Active")) {
			System.out.println("signing in......");

			System.out.println(count.getCountLogin());

			if (count.getCountLogin() == 0) {
				System.out.println("Coming to login count 0....");
				if(encoder.matches(password,count.getPassword())) {
				RegisterDto useremailpass = dtoServiceImpl.getemailndpassword(registerdto.getEmail(),
						count.getPassword());

				if (useremailpass != null) {
					count.setAccountLock(3);
					System.out.println("logging in sucessfully...");
					count.setCountLogin(1);
					count.setUpdatedBy(count.getFirstName());
					count.setUpdatedDate(LocalDate.now());
					
					repository.save(count);

					Optional<RegisterDto> Optuser = repository.getbyemail(registerdto.getEmail());
					HttpSession httpSession = request.getSession();
					System.out.println(httpSession);
					httpSession.setAttribute("user", Optuser.get());
					System.out.println("user========>" + (RegisterDto) httpSession.getAttribute("user"));

//		            set session for displaying image
					String profileImageUrl = "/uploading/" + Optuser.get().getProfileImage();
					System.out.println(profileImageUrl);
					httpSession.setAttribute("profileImage", profileImageUrl);

					model.addAttribute("dto", Optuser.get());
					model.addAttribute("message", "Login Successful, Welcome Back");
					model.addAttribute("action", "retain");
					model.addAttribute("key", useremailpass.getEmail());

					return "PasswordReset";
				}
				}else {

					model.addAttribute("msg1", "Wrong email or password ");
					return "Login";
				}


			}
			

			if (count.getCountLogin() >= 1) {

				System.out.println("coming to login count 1..");
				if(encoder.matches(password,count.getPassword())) {
				RegisterDto useremailpass = repository.getEmailAndPass(registerdto.getEmail(),
						count.getPassword());
				System.out.println(useremailpass);
				if (useremailpass != null) {

					System.out.println("logging in..");
					count.setAccountLock(3);
					count.setCountLogin(count.getCountLogin() + 1);
					repository.save(count);
					Optional<RegisterDto> Optuser = repository.getbyemail(registerdto.getEmail());
					HttpSession httpSession = request.getSession();
					System.out.println(httpSession);
					httpSession.setAttribute("user", Optuser.get());
					System.out.println("user========>" + (RegisterDto) httpSession.getAttribute("user"));

//		            set session for displaying image
					String profileImageUrl = "/uploading/" + Optuser.get().getProfileImage();
					System.out.println(profileImageUrl);
					httpSession.setAttribute("profileImage", profileImageUrl);

					model.addAttribute("dto", Optuser.get());
					model.addAttribute("msg", "Login Successful, Welcome Back");
					return "Home";
				}} else {

					model.addAttribute("msg1",
							"Wrong email or password " + "u have " + (count.getAccountLock() - 1) + "attempts left");
					count.setAccountLock(count.getAccountLock() - 1);
					repository.save(count);

					if (count.getAccountLock() == 0) {
						model.addAttribute("msg1", "Your Account has been locked due to 3 wrong attempts please do "
								+ "Forgot password to reset password and Login ");
						count.setCountLogin(0);
						count.setPassword(null);

						repository.save(count);

						return "Login";

					}

					return "Login";
				}

			}
			}else {
				model.addAttribute("msg1","Your Account is Inactive Please Contact Admin to Reactivate Your Account");
				return "Login";
				
			}

			return null;

		} catch (Exception e) {
			// TODO: handle exception

			model.addAttribute("msg1", "Please enter valid email and Password");
			return "Login";
		}
	}
}

	
	
