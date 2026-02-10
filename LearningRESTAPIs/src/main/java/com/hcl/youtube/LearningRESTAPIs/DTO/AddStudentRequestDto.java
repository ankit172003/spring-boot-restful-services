package com.hcl.youtube.LearningRESTAPIs.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddStudentRequestDto {

	@NotBlank(message = "Name is required")
	@Size(min=3, max=30, message="Name should be of length 3 to 30 " )
	private String name;
	
	@Email
	@NotBlank(message = "Email is Required")
	private String email;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddStudentRequestDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public AddStudentRequestDto() {
		super();
	}
	
	
}
