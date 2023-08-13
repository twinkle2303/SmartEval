package com.smarteval.entities;

import java.sql.Date;
import java.util.Objects;

public class OngoingPapers {
	private Integer paperID;
	private Integer examID;
	private String paperName;
	private String examName;
	private Date paperDate;
	
	public OngoingPapers() {
		super();
	}

	public OngoingPapers(Integer paperID, Integer examID, String paperName, String examName, Date paperDate) {
		super();
		this.paperID = paperID;
		this.examID = examID;
		this.paperDate = paperDate;
		this.paperName = paperName;
		this.examName = examName;
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

	public Date getPaperDate() {
		return paperDate;
	}

	public void setPaperDate(Date paperDate) {
		this.paperDate = paperDate;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(examID, examName, paperDate, paperID, paperName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OngoingPapers other = (OngoingPapers) obj;
		return Objects.equals(examID, other.examID) && Objects.equals(examName, other.examName)
				&& Objects.equals(paperDate, other.paperDate) && Objects.equals(paperID, other.paperID)
				&& Objects.equals(paperName, other.paperName);
	}
}