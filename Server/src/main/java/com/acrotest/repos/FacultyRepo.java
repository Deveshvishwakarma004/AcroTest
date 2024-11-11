package com.acrotest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Integer> {

}
