package com.acrotest.controllers;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrotest.config.JWTBuilder;
import com.acrotest.entities.User;
import com.acrotest.models.FacReg;
import com.acrotest.models.Login;
import com.acrotest.models.LoginResponse;
import com.acrotest.models.StudReg;
import com.acrotest.services.FacultyService;
import com.acrotest.services.StudentService;
import com.acrotest.services.UserService;
import com.acrotest.utils.ApiResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/acro")
public class AccroController extends BaseController{
	
	@Autowired
	private StudentService studService;
	
	@Autowired
	private FacultyService facservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JWTBuilder jwtBuilder;
	
	@Autowired
	private AuthenticationManager authenticatemanager;
	
	private HashMap<String ,String> roles;
	
	public AccroController() {
		roles = new HashMap();
		roles.put("ROLE_ADMIN", "admin");
		roles.put("ROLE_STUDENT", "student");
		roles.put("ROLE_FACULTY", "faculty");
	}
	
	@PostMapping("/stud_reg")
	public ApiResponse registerStudent(@Valid @RequestBody StudReg regObj) 
	{
		regObj.setPassword(encoder.encode(regObj.getPassword()));
		return studService.register(regObj);
	}  
  
	@PostMapping("/fac_reg")
	public ApiResponse registerFaculty(@Valid @RequestBody FacReg regObj) 
	{
		regObj.setPassword(encoder.encode(regObj.getPassword()));
		return facservice.register(regObj);
	} 
	
	@PostMapping("/login")
	public ApiResponse login(@Valid @RequestBody Login model)
	{
		try {
		authenticatemanager.authenticate
		(new UsernamePasswordAuthenticationToken(model.getEmail(), model.getPassword()));
		User user = (User)userservice.loadUserByUsername(model.getEmail());
		if(user == null)
			return new ApiResponse(false, "Invalid User", "Login Failed", null);
		else {
			String token = jwtBuilder.generateToken(user);
			LoginResponse op = new LoginResponse(user.getName(), token , roles.get(user.getRole()));
			return new ApiResponse(true, "Login Successfull", op);
		}
		}catch(Exception e){
		   return new ApiResponse(false, "Invalid User" , null);	
		}
	} 
	
	@GetMapping("/accessDenied")
	public ApiResponse accessDenied() {
		return new ApiResponse(false, "Access Denied , No Access !", null);
	}
	
}
