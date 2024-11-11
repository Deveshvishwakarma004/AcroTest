package com.acrotest.entities;

import com.acrotest.models.StudReg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User {

	public Student() {
		super();
	}

	@Column(name = "enroll_number", nullable = false, unique = true)
	private String enroll;

	@Column(name = "branch", nullable = false)
	private String branch;

	@Column(name = "semester", nullable = false)
	private Integer semester;

	public Student(String enrollnum, String branch, Integer sem) {
		super();
		this.enroll = enrollnum;
		this.branch = branch;
		this.semester = sem;
	}

	public Student(StudReg regObj) {
		this.enroll = regObj.getEnroll();
		this.branch = regObj.getBranch();
		this.semester = regObj.getSemester();
		this.setEmail(regObj.getEmail());
		this.setName(regObj.getName());
		this.setPassword(regObj.getPassword());
		this.setRole("ROLE_STUDENT");
	}

	public String getEnrollnum() {
		return enroll;
	}

	public void setEnrollnum(String enrollnum) {
		this.enroll = enrollnum;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getSem() {
		return semester;
	}

	public void setSem(Integer sem) {
		this.semester = sem;
	}

}
