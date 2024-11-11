package com.acrotest.entities;


import com.acrotest.models.QuesModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "questions")
public class Questions {
	

	@Id
	  @Column(name = "quesid")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer quesId;
	  
	  @Column(name = "question",nullable = false)
	  private String question;
	  
	  @Column(name = "ans1",nullable = false)
	  private String ans1;
	  @Column(name = "ans2",nullable = false)
	  private String ans2;
	  @Column(name = "ans3",nullable = false)
	  private String ans3;
	  @Column(name = "ans4",nullable = false)
	  private String ans4;
	  @Column(name = "right_ans" , nullable = false)
	  private int rightAns;
	  
	  @ManyToOne
	  @JoinColumn(name = "test")
	  private Test test;

	public Questions(Integer quesId, String question, String ans1, String ans2, String ans3, String ans4,
			int rightAns, Test test) {
		super();
		this.quesId = quesId;
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.rightAns = rightAns;
		this.test = test;
	}

	public Questions() {
		super();
	}
    
	 public Questions(QuesModel model) {
			this.question = model.getQuestion();
			this.ans1 = model.getAns1();
			this.ans2 = model.getAns2();
			this.ans3 = model.getAns3();
			this.ans4 = model.getAns4();
			this.rightAns = model.getRightAns();
		}
	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
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

	public void setRightAns(int rightAns) {
		this.rightAns = rightAns;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	  
	  
}
