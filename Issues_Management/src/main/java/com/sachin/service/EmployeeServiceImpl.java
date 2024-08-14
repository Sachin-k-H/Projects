package com.sachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.sachin.dto.EmployeeDto;
import com.sachin.repository.EmplyoeeRepo;
import com.sachin.util.PasswordGenerator2;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmplyoeeRepo employeerepo;
	
	
	public void sendEmail2(EmployeeDto employeedto,String password) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(employeedto.getEmail());
		simpleMailMessage.setSubject("Welcome Aboard!");
		simpleMailMessage.setText("Hi ,"+employeedto.getName() +"\n" +"you have been Assigned to "+employeedto.getDepartment()
		+"Department ."		+ " Below is your Login Email" + "," + "\n"
				+ " you can Login using this Email and a OTP that is sent to u below."+"\n"+password
				+ "\n" + "\n" +  "\n\n\n\n" + " Regards,\n" + " " + "X-workz Team");
		javaMailSender.send(simpleMailMessage);
	}

	
	
	public EmployeeDto  checkemailpassdept(EmployeeDto employeedto) {
		
		return employeerepo.getEmployeeByEmailPasswordDept(employeedto.getEmail(), employeedto.getPassword(),employeedto.getDepartment());
	}
	
	public EmployeeDto save_And_sendEmail(EmployeeDto employeedto) {
		System.out.println("Saving data......");
		String password = PasswordGenerator2.generatePassword();
		
		System.out.println(password);
		employeedto.setPassword(password);
		employeedto.setStatus("Active");
		EmployeeDto emailispresent = employeerepo.getEmployeeByEmail(employeedto.getEmail());
		EmployeeDto phoneispresent = employeerepo.getEmployeeByPassword(employeedto.getPassword());
		if (emailispresent != null || phoneispresent != null) {
			System.out.println("Mail or phone already registered");
			System.out.println("Data did not save.....");
			return null;
		} else {
			System.out.println("data is valid and saved");
			sendEmail2(employeedto, password);
			System.out.println(password);
			return employeerepo.save(employeedto);
		}
	}
}
