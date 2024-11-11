package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FacReg {
	@NotNull(message = "Name Can't be Null")
	@NotEmpty(message = "Empty Name Not Allowed")
	private String name;
	
	@NotNull(message = "Email Can't be Null")
	@NotEmpty(message = "Empty Email Not Allowed")
	private String email;
	
	
	@NotNull(message = "Password Can't be Null")
	@NotEmpty(message = "Empty Password Not Allowed")
	private String password;
	
	@NotNull(message = "Faculty Id  Can't be Null")
	private int facid;
	
	@NotNull(message = "Phone  Can't be Null")
	@NotEmpty(message = "Empty Phone number Not Allowed")
	private String phone;

	public FacReg() {
		super();
	}

	public FacReg(@NotNull(message = "Name Can't be Null") @NotEmpty(message = "Empty Name Not Allowed") String name,
			@NotNull(message = "Email Can't be Null") @NotEmpty(message = "Empty Email Not Allowed") String email,
			@NotNull(message = "Password Can't be Null") @NotEmpty(message = "Empty Password Not Allowed") String password,
			@NotNull(message = "Faculty Id  Can't be Null") int facid,
			@NotNull(message = "Phone  Can't be Null") @NotEmpty(message = "Empty Phone number Not Allowed") String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.facid = facid;
		this.phone = phone;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFacid() {
		return facid;
	}

	public void setFacid(int facid) {
		this.facid = facid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
