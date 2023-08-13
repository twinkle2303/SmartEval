package com.smarteval.entities;

import java.util.Objects;

public class AnswerBank {
	
	Integer userID;
	Integer examID;
	Integer paperID;
	Integer questionID;
	String answer;
	
	public AnswerBank() {
		super();
	}
	public AnswerBank(Integer userID, Integer examID, Integer paperID, Integer questionID, String answer) {
		super();
		this.userID = userID;
		this.examID = examID;
		this.paperID = paperID;
		this.questionID = questionID;
		this.answer = answer;
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	public Integer getPaperID() {
		return paperID;
	}
	public void setPaperID(Integer paperID) {
		this.paperID = paperID;
	}
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "AnswerBank [userID=" + userID + ", examID=" + examID + ", paperID=" + paperID + ", questionID="
				+ questionID + ", answer=" + answer + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(answer, examID, paperID, questionID, userID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerBank other = (AnswerBank) obj;
		
		return Objects.equals(answer, other.answer) && Objects.equals(examID, other.examID)
				&& Objects.equals(paperID, other.paperID) && Objects.equals(questionID, other.questionID)
				&& Objects.equals(userID, other.userID);
	}
}