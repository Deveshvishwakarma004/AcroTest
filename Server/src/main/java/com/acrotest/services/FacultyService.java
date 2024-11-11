package com.acrotest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Faculty;
import com.acrotest.models.FacReg;
import com.acrotest.repos.FacultyRepo;
import com.acrotest.utils.ApiResponse;


@Service
public class FacultyService {

	@Autowired
	private FacultyRepo facRepo;
	public ApiResponse register(FacReg regObj) {
		try
		{
			Faculty ob = new Faculty(regObj);
			facRepo.save(ob);
			return new ApiResponse(true, "Faculty Registered Successfully", null);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Faculty Registration Failed !", e.getMessage());
		}
	}

}
