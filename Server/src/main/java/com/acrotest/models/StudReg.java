package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudReg {

	@NotNull(message = "Name Can't be Null")
	@NotEmpty(message = "Empty Name Not Allowed")
	private String name;
	
	@NotNull(message = "Branch Can't be Null")
	@NotEmpty(message = "Empty Branch Not Allowed")
	private String branch;
	
	
	@NotNull(message = "EnRoll Can't be Null")
	@NotEmpty(message = "Empty Enroll Not Allowed")
	private String enroll;
	
	
	@NotNull(message = "Sem Can't be Null")
	private int semester;
	
	
	@NotNull(message = "Email Can't be Null")
	@NotEmpty(message = "Empty Email Not Allowed")
	private String email;
	
	
	@NotNull(message = "Password Can't be Null")
	@NotEmpty(message = "Empty Password Not Allowed")
	private String password;

	public StudReg() {
		super();
	}

	public StudReg(String name, String branch, String enroll, int semester, String email, String password) {
		super();
		this.name = name;
		this.branch = branch;
		this.enroll = enroll;
		this.semester = semester;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEnroll() {
		return enroll;
	}

	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
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

}
