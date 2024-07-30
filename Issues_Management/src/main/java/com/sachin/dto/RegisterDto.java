package com.sachin.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Signup_Table")
public class RegisterDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Please Enter First Name")
	@Size(min = 3, max = 30, message = "The First name should be at least 3 to 30 characters")
	@Column(name="First_Name")
	private String firstName;
	@NotNull(message = "Please Enter Last Name")
	@Size(min = 1, max = 30, message = "The Last name should be at least 3 to 30 characters")
	@Column(name="Last_Name")
	private String lastName;
    @NotNull(message = "Please provide valid Email")
	@Email(message = "Please provide valid Email")
	@Column(name="Email")
	private String email;
	
	@NotNull(message="Please provide valid Phone Number")
	@Min(1)
	@Max(9999999999L)
	private Long phone;
	
	
	private String password;
	
	private String createdBy;
    private String updatedBy;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    
   // private String userPassword;
    @Column(name="Login_Count")
    private int countLogin;
    private int accountLock;
    @Column(name = "profile_image")
    private String profileImage;
    private String accountStatus;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	public int getCountLogin() {
		return countLogin;
	}
	public int setCountLogin(int countLogin) {
		this.countLogin = countLogin;
		return countLogin;
	}
	public int getAccountLock() {
		return accountLock;
	}
	public void setAccountLock(int accountLock) {
		this.accountLock = accountLock;
	}
	@Override
	public String toString() {
		return "RegisterDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", countLogin="
				+ countLogin + ", accountLock=" + accountLock + ", profileImage=" + profileImage + ", accountStatus="
				+ accountStatus + "]";
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	

	
	

}
