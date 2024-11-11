package com.acrotest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Student;
import com.acrotest.models.StudReg;
import com.acrotest.repos.StudentRepo;
import com.acrotest.utils.ApiResponse;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studRepo;
	
	public ApiResponse register(StudReg regObj) {
		try
		{
			Student ob = new Student(regObj);
			studRepo.save(ob);
			return new ApiResponse(true, "Student Registered Successfully", null);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Student Registration Failed !", e.getMessage());
		}
	}

}
