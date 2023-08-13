package com.smarteval.entities;

import java.util.Objects;

public class ExamQuestions {
	private Integer paperID;
	private Integer examID;
	private Integer questionID;
	private Integer noOfQuestions;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	
	public ExamQuestions() {
		super();
	}
	
	public ExamQuestions(Integer paperID, Integer examID, 
			Integer questionID, Integer noOfQuestions, 
			String question, String option1, String option2,
			String option3, String option4) {
		super();
		this.paperID = paperID;
		this.examID = examID;
		this.questionID = questionID;
		this.noOfQuestions = noOfQuestions;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	
	public Integer getPaperID() {
		return paperID;
	}
	public void setPaperID(Integer paperID) {
		this.paperID = paperID;
	}
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public Integer getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(Integer noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	@Override
	public String toString() {
		return "ExamQuestions [paperID=" + paperID + ", examID=" + examID + ", questionID=" + questionID
				+ ", noOfQuestions=" + noOfQuestions + ", question=" + question + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(examID, noOfQuestions, option1, option2, option3, option4, paperID, question, questionID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamQuestions other = (ExamQuestions) obj;
		return Objects.equals(examID, other.examID) && Objects.equals(noOfQuestions, other.noOfQuestions)
				&& Objects.equals(option1, other.option1) && Objects.equals(option2, other.option2)
				&& Objects.equals(option3, other.option3) && Objects.equals(option4, other.option4)
				&& Objects.equals(paperID, other.paperID) && Objects.equals(question, other.question)
				&& Objects.equals(questionID, other.questionID);
	}
	
	
}
