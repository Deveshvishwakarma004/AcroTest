package com.acrotest.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.acrotest.entities.Questions;
import com.acrotest.entities.Test;

@Repository
public interface QuesRepo extends JpaRepository<Questions, Integer> 
{

	List<Questions> findByTest(Test test);
// List<Questions> findbytest(Test test);
}
