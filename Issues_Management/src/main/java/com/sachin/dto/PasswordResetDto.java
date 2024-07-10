package com.sachin.dto;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetDto {
	@NotEmpty(message = "please enter password")
    private String password;
    @NotEmpty(message = "please enter email")
    private String email;
    @NotEmpty(message = "please enter  new password")
    private String newpassword;
    @NotEmpty(message = "please enter confirm password")
    private String confirmpassword;

   
}
