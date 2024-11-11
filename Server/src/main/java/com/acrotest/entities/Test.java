package com.acrotest.entities;

import java.time.LocalDate;

import com.acrotest.models.TestModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="testinfo")
public class Test {
  @Id
  @Column(name = "testid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer testId;
  
  @Column(name = "title" , nullable = false)
  private String title;
  
  @Column(name = "test_date",nullable = false)
  private LocalDate testDate;
  
  @Column(name = "post_date" , nullable = false)
  private LocalDate postDate;
  
  @Column(name = "status",nullable = false)
  private Boolean status;
  
  @ManyToOne
  @JoinColumn(name = "faculty")
  private User user;

public Test() {
	super();
}

public Test(Integer testId,  String title,LocalDate testDate, LocalDate postDate, Boolean status , User user) {
	super();
	this.testId = testId;
	this.title = title;
	this.testDate = testDate;
	this.postDate = postDate;
	this.status = status;
	this.user = user;
}

public Test(TestModel model) {
	this.title = model.getTitle();
	this.testDate = model.getDate();
	this.postDate = LocalDate.now();
	this.status  = true;
}

public Integer getTestId() {
	return testId;
}

public void setTestId(Integer testId) {
	this.testId = testId;
}

public LocalDate getTestDate() {
	return testDate;
}

public void setTestDate(LocalDate testDate) {
	this.testDate = testDate;
}

public LocalDate getPostDate() {
	return postDate;
}

public void setPostDate(LocalDate postDate) {
	this.postDate = postDate;
}

public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

  
}
