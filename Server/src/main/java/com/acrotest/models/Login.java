package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Login {

	@NotNull(message = "Email Can't be Null")
	@NotEmpty(message = "Empty Email Not Allowed")
	private String email;
	
	
	@NotNull(message = "Password Can't be Null")
	@NotEmpty(message = "Empty Password Not Allowed")
	private String password;


	public Login() {
		super();
	}


	public Login(@NotNull(message = "Email Can't be Null") @NotEmpty(message = "Empty Email Not Allowed") String email,
			@NotNull(message = "Password Can't be Null") @NotEmpty(message = "Empty Password Not Allowed") String password) {
		super();
		this.email = email;
		this.password = password;
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
