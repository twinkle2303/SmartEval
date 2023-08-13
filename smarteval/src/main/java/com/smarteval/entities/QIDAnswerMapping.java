package com.smarteval.entities;

import java.util.Objects;

public class QIDAnswerMapping {
	private Integer questionID;
	private String answer;
	
	public QIDAnswerMapping() {
		super();
	}

	public QIDAnswerMapping(Integer questionID, String answer) {
		super();
		this.questionID = questionID;
		this.answer = answer;
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
		return "QIDAnswerMapping [questionID=" + questionID + ", answer=" + answer + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(answer, questionID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QIDAnswerMapping other = (QIDAnswerMapping) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(questionID, other.questionID);
	}
}
