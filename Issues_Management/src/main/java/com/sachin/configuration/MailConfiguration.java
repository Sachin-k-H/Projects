package com.sachin.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
public class MailConfiguration {

	@Bean
	public JavaMailSender javamailsender() {
		JavaMailSenderImpl javamailsenderimpl =new JavaMailSenderImpl();
		javamailsenderimpl.setHost("smtp.gmail.com");	
		javamailsenderimpl.setPort(587);
		javamailsenderimpl.setUsername("sachinkhxworkz@gmail.com");
		javamailsenderimpl.setPassword("hahc zqgg cnvm tilt");
		Properties properties = javamailsenderimpl.getJavaMailProperties();
		properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","true");
		return javamailsenderimpl;
	}
	
	
	
}
