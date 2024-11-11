package com.acrotest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrotest.entities.Questions;
import com.acrotest.entities.Test;
import com.acrotest.entities.User;
import com.acrotest.models.QuesModel;
import com.acrotest.models.TestModel;
import com.acrotest.services.TestService;
import com.acrotest.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/faculty")
public class FacultyController  extends BaseController{
   @Autowired
   private TestService testService;
   
   @PostMapping("/savetest")
   public ApiResponse saveTest(@Valid @RequestBody TestModel model) {
	  
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   User loginuser = ((User) principal);
	   return testService.saveTest(model , loginuser);
   }
   
   @PostMapping("/saveques/{testid}")
   public ApiResponse saveQues(@Valid @RequestBody QuesModel model,
		   @PathVariable(value = "testid") Integer testid) {
	   return testService.saveQuestion(model , testid);
   }
   
   public ApiResponse listQus(@PathVariable(value = "testid") Integer testid) 
	{
		List<Questions> list =  testService.listQuestions(testid);
		ApiResponse res = new ApiResponse(true, "Questions Records", list);
		return res;
	}
   @GetMapping("/mytestlist")
   public ApiResponse factestlist() {
	   Object principal = SecurityContextHolder
			   .getContext()
			   .getAuthentication()
			   .getPrincipal();
	   User loginuser = ((User) principal);
	   List<Test> lt = testService.testlistfac(loginuser);
	   ApiResponse res = new ApiResponse(true, "Test Records", lt);
	   return res;
   }
}
