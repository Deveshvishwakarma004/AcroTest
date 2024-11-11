package com.acrotest.models;

public class LoginResponse {
  private String name;
  private String token;
  private String role;
public LoginResponse(String name, String token, String role) {
	super();
	this.name = name;
	this.token = token;
	this.role = role;
}
public LoginResponse() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
  
}
