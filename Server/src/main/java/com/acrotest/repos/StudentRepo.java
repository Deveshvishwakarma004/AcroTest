package com.acrotest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
