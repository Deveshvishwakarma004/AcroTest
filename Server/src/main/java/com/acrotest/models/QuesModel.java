package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class QuesModel 
{
  @NotNull(message = "Questions can't be null")
  @NotEmpty(message = "Questions can't be empty")
  private String question;
  
  @NotNull(message = "Answer 1 can't be null")
  @NotEmpty(message = "Answer 1 can't be empty")
  private String ans1;
  
  @NotNull(message = "Answer 2 can't be null")
  @NotEmpty(message = "Answer 2 can't be empty")
  private String ans2;
  
  @NotNull(message = "Answer 3 can't be null")
  @NotEmpty(message = "Answer 3  can't be empty")
  private String ans3;
  
  @NotNull(message = "Answer 4 can't be null")
  @NotEmpty(message = "Answer 4 can't be empty")
  private String ans4;
  
  @NotNull(message = "Right Answer  can't be null")
  private int rightAns;
public QuesModel() {
	super();
}
public QuesModel(@NotNull String question, String ans1, String ans2, String ans3, String ans4, @NotNull(message = "Right Answer  can't be null") @NotEmpty(message = "Right Answer  can't be empty") int rightAns) {
	super();
	this.question = question;
	this.ans1 = ans1;
	this.ans2 = ans2;
	this.ans3 = ans3;
	this.ans4 = ans4;
	this.rightAns = rightAns;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAns1() {
	return ans1;
}
public void setAns1(String ans1) {
	this.ans1 = ans1;
}
public String getAns2() {
	return ans2;
}
public void setAns2(String ans2) {
	this.ans2 = ans2;
}
public String getAns3() {
	return ans3;
}
public void setAns3(String ans3) {
	this.ans3 = ans3;
}
public String getAns4() {
	return ans4;
}
public void setAns4(String ans4) {
	this.ans4 = ans4;
}
public int getRightAns() {
	return rightAns;
}
public void setRightAns(@NotNull(message = "Right Answer  can't be null") @NotEmpty(message = "Right Answer  can't be empty") int rightAns) {
	this.rightAns = rightAns;
}
  
  
}
