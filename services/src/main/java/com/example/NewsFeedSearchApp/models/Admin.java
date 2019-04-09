package com.example.NewsFeedSearchApp.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String adminId;
	
	@NotBlank(message="Admin Mail Required")
	@Email(message="Email Should be vailid")
	private String email;
	
	@NotBlank(message="Admin password Required")
	@Pattern(regexp="^(?=.*?[A-Z]) (?=.*[a-z]) (?=.*[0-9]).{8,}$",message="Password must contain at least eight characters, one capital letter, one small letter and at least one number")
	private String password;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
