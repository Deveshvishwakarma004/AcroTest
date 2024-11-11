package com.acrotest.entities;

import com.acrotest.models.FacReg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty extends User{
	
	
	@Column(name = "facid", nullable = false , unique = true)
	private Integer facid;

	@Column(name = "phone", nullable = false)
	private String phone;

	public Faculty() {
		super();
	}

	public Faculty(Integer facid, String phone) {
		super();
		this.facid = facid;
		this.phone = phone;
	}
	
	

	public Faculty(FacReg regObj) {
		this.facid = regObj.getFacid();
		this.phone = regObj.getPhone();
		this.setEmail(regObj.getEmail());
		this.setName(regObj.getName());
		this.setPassword(regObj.getPassword());
		this.setRole("ROLE_FACULTY");
	}

	public Integer getFacid() {
		return facid;
	}

	public void setFacid(Integer facid) {
		this.facid = facid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
