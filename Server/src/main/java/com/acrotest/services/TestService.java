package com.acrotest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Questions;
import com.acrotest.entities.Test;
import com.acrotest.entities.User;
import com.acrotest.models.QuesModel;
import com.acrotest.models.TestModel;
import com.acrotest.repos.QuesRepo;
import com.acrotest.repos.TestRepo;
import com.acrotest.utils.ApiResponse;

import jakarta.validation.Valid;

@Service
public class TestService {

	@Autowired
	private TestRepo testRepo;
	
	@Autowired
	private QuesRepo quesRepo;

	public ApiResponse saveTest(TestModel model  , User user) {
		try
		{
			Test ob = new Test(model);
			ob.setUser(user);
			testRepo.save(ob);
			return new ApiResponse(true, "Test Saved Successfully", null);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Test Save Failed !", e.getMessage());
		}
	}

	public ApiResponse saveQuestion(@Valid QuesModel model, Integer testid) {
		try
		{
			Optional <Test> op = testRepo.findById(testid);
			if(op.isPresent()) {
				Questions tq = new Questions(model);
			    tq.setTest(op.get());
				quesRepo.save(tq);
				return new ApiResponse(true, "Test Ques Saved Successfully", null);
			}
			else {
				return new ApiResponse(true, "Wrong Ques Id !!", null);
			}
			
		}
		catch(Exception e) {
			return new ApiResponse(false, "Test  Ques Save Failed !", e.getMessage());
		}
	}

	public List<Test> listall() {
		
		return testRepo.findByStatus(true);
	}

	public List<Test >testlistfac(User user) {
		return testRepo.findByUser(user);
	}

	public List<Questions> listQuestions(Integer testid) 
	{
		Optional<Test> op = testRepo.findById(testid);
		if(op.isPresent())
		{
			return quesRepo.findByTest(op.get());
		}else
			return null;
	}
	
}
