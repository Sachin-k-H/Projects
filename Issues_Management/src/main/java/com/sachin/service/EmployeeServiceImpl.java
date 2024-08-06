package com.sachin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sachin.dto.EmployeeDto;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail2(EmployeeDto employeedto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(employeedto.getEmail());
		simpleMailMessage.setSubject("Welcome Aboard!");
		simpleMailMessage.setText("Hi ,"+employeedto.getName() +"\n" +"you have been Assigned to "+employeedto.getDepartment()
		+"Department ."		+ " Below is your Login Email" + "," + "\n"
				+ " you can Login using this Email and a OTP that is sent to you at time of Login ."
				+ "\n" + "\n" +  "\n\n\n\n" + " Regards,\n" + " " + "X-workz Team");
		javaMailSender.send(simpleMailMessage);
	}

}
