package com.smarteval.entities;

import java.sql.Date;
import java.util.Objects;

public class Examination {
	private Integer examID;
	private Date examDate;
	private String examName;
	private String examDesc;
	
	public Examination() {
		super();
	}
	
	public Examination(Integer examID, Date examDate, String examName, String examDesc) {
		super();
		this.examID = examID;
		this.examDate = examDate;
		this.examName = examName;
		this.examDesc = examDesc;
	}
	
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamDesc() {
		return examDesc;
	}
	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(examDate, examDesc, examID, examName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examination other = (Examination) obj;
		return Objects.equals(examDate, other.examDate) && Objects.equals(examDesc, other.examDesc)
				&& Objects.equals(examID, other.examID) && Objects.equals(examName, other.examName);
	}
	
	
}