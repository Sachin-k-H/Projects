package com.sachin.service;

import java.beans.Encoder;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sachin.dto.Admin;
import com.sachin.dto.RegisterDto;

import com.sachin.repository.Repository;
import com.sachin.util.PasswordGenerator2;

@Service
public class DtoServiceImpl implements DtoService {

	@Autowired
	private Repository repository;

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void RegisterUser(RegisterDto registerdto) {

		System.out.println(registerdto);

		repository.save(registerdto);
	}

	public void sendEmail(RegisterDto registerdto, String password) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(registerdto.getEmail());
		simpleMailMessage.setSubject("Welcome Aboard!");
		simpleMailMessage.setText("Dear " + registerdto.getFirstName() + " " + registerdto.getLastName() + "," + "\n"
				+ " you have signnedup successfully into our Website." + "\n"
				+ "To Further Assist you with Our services Please SignIn through this Temporary password and Set a New Password of your Convenience :"
				+ "\n" + password + "\n\n\n\n" + " Regards,\n" + " " + "X-workz Team");
		javaMailSender.send(simpleMailMessage);
	}

	public Optional<RegisterDto> save(RegisterDto registerdto) {

		System.out.println("Saving data......");
		String password = PasswordGenerator2.generatePassword();
		String encodedpassword = encoder.encode(password);
		System.out.println(encodedpassword);
		registerdto.setPassword(encodedpassword);
		registerdto.setCreatedBy(registerdto.getFirstName());
		registerdto.setCreatedDate(LocalDate.now());
		registerdto.setCountLogin(0);
		registerdto.setAccountLock(3);
		registerdto.setAccountStatus("Active");
		registerdto.setProfileImage("icons8-user-24.PNG");
		RegisterDto emailispresent = repository.searchByEmail(registerdto.getEmail());
		RegisterDto phoneispresent = repository.searchByPhone(registerdto.getPhone());
		if (emailispresent != null || phoneispresent != null) {
			System.out.println("Mail or phone already registered");

			return Optional.empty();

		}

		else {
			RegisterUser(registerdto);

			System.out.println("data is valid and saved");
			sendEmail(registerdto, password);
			System.out.println();
			return Optional.ofNullable(registerdto);
		}

	}

	@Override
	public RegisterDto getemailndpassword(String email, String pass) {

		return repository.searchbyemailandpassword(email, pass);
	}

	@Override
	public RegisterDto getuserbyid(RegisterDto registerdto) {
		// TODO Auto-generated method stub
		return repository.findById(registerdto.getId()).get();
	}

	@Override
	public RegisterDto getemail(String email) {
		// TODO Auto-generated method stub
		return repository.searchEmail(email);
	}

	@Override
	public Optional<RegisterDto> getphone(RegisterDto registerdto) {
		// TODO Auto-generated method stub
		return repository.searchPhone(registerdto.getPhone());
	}

	@Override
	public RegisterDto getuserbyid(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Admin getFirstemailpassword(String email, String pass) {

		return repository.findByEmailAndPassword(email, pass);
	}

	@Override
	public List<RegisterDto> getAllRegistereduser() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteuser(int id) {
		repository.deleteById(id);
	}

	@Override
	public Admin getadminemail(String email) {
		return repository.searchbyEmail(email);
	}

}
