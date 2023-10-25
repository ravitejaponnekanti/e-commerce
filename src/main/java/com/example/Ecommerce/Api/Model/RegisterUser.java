package com.example.Ecommerce.Api.Model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Component
public class RegisterUser {
	
	@NotNull
	@NotBlank
	@Size(min=3,max=40)
	private String firstname;
	@NotNull
	@NotBlank
	@Size(min=3,max=40)
	private String lastname;
	@NotNull
	@NotBlank
	@Size(min=3,max=255)
	@Email
	private String email;
	@NotNull
	@NotBlank
	@Size(min=3,max=40)
	private String username;
	@NotNull
	@Size(min=6,max=40)
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
	private String password;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
