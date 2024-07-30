package com.sachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sachin.dto.DepartmentAdmin;
import com.sachin.repository.DepartmentAdminRepo;
import com.sachin.util.PasswordGenerator2;

@Service
public class DepartmentAdminServiceImpl implements DepartmentAdminService {
	@Autowired
	private DepartmentAdminRepo departmentadminrepo;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public DepartmentAdmin save_and_sendemail(DepartmentAdmin departmentAdmin) {

		System.out.println("Saving data......");
		String password = PasswordGenerator2.generatePassword();
		String encodedpassword = encoder.encode(password);
		System.out.println(encodedpassword);
		departmentAdmin.setPassword(encodedpassword);
		DepartmentAdmin emailispresent = departmentadminrepo.searchByEmail(departmentAdmin.getEmail());
		DepartmentAdmin phoneispresent = departmentadminrepo.searchByPhone(departmentAdmin.getPhone());
		if (emailispresent != null || phoneispresent != null) {
			System.out.println("Mail or phone already registered");
			System.out.println("Data did not save.....");
			return null;
		} else {

			System.out.println("data is valid and saved");
			sendEmail(departmentAdmin, password);
			System.out.println(password);
			return departmentadminrepo.save(departmentAdmin);
		}

	}

	public void sendEmail(DepartmentAdmin departmentAdmin, String password) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(departmentAdmin.getEmail());
		simpleMailMessage.setSubject("Welcome Aboard!");
		simpleMailMessage.setText("Hi ," +"\n" +"you have been Assigned as a DepartmentAdmin"
				+ " below are your Acces Credentials" + "," + "\n"
				+ " you can Login using these credentials into the Portal and Set a New Password of your Convenience."
				+ "\n" + "\n" + password + "\n\n\n\n" + " Regards,\n" + " " + "X-workz Team");
		javaMailSender.send(simpleMailMessage);
	}

	@Override
	public DepartmentAdmin checkemailpassdept(DepartmentAdmin Admin) {
		DepartmentAdmin admindata = departmentadminrepo.searchByEmail(Admin.getEmail());
		 String encodedpassword=admindata.getPassword();
		if(encoder.matches(Admin.getPassword(), encodedpassword)) {
		return departmentadminrepo.searchByEmailPassDept(Admin.getEmail(), admindata.getPassword(), Admin.getDepartment());
	}
		System.out.println("Wrong credentials........");
		
		return null;
	}
	
	
	public DepartmentAdmin update(DepartmentAdmin Admin) {
		return departmentadminrepo.save(Admin);
	}
}
