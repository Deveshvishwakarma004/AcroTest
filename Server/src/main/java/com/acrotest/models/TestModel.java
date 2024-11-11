package com.acrotest.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TestModel {
	
  @NotNull(message = "Title Can't be Null")
  @NotEmpty(message = "Title Can't be Empty")
  private String title;
	
  @NotNull(message = "Test Date Can't be Null")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

public TestModel() {
	super();
}

public TestModel(@NotNull(message = "Title Can't be Null") @NotEmpty(message = "Title Can't be Empty") String title,
		@NotNull(message = "Test Date Can't be Null") LocalDate date) {
	super();
	this.title = title;
	this.date = date;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}
  
  
}
