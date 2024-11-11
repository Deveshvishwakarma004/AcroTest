package com.acrotest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrotest.entities.Test;
import com.acrotest.entities.User;
import com.acrotest.services.TestService;
import com.acrotest.services.UserService;
import com.acrotest.utils.ApiResponse;

@RestController
@RequestMapping("/auth/admin")
public class AdminController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private TestService testservice;
	
	@GetMapping("/faculties")
	public ApiResponse faclist() {
		List <User> flist = userService.listByRole("ROLE_FACULTY");
		ApiResponse res = new ApiResponse(true, "Faculty Records", flist);
		return res;
	}
	@GetMapping("/students")
	public ApiResponse studlist() {
		List <User> slist = userService.listByRole("ROLE_STUDENT");
		ApiResponse res = new ApiResponse(true, "Student Records", slist);
		return res;
	}
	@GetMapping("/testlist")
	public ApiResponse testlist() {
		List<Test> lt = testservice.listall();
		ApiResponse res =  new ApiResponse(true, "Test List", lt);
		return res;
	}
}
