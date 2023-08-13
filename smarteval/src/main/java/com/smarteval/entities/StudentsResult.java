package com.smarteval.entities;

import java.util.Objects;

public class StudentsResult {
	private String username;
	private String subject;
	private Integer marks;
	
	public StudentsResult() {
		super();
	}
	
	public StudentsResult(String username, String subject, Integer marks) {
		super();
		this.username = username;
		this.subject = subject;
		this.marks = marks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marks, subject, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentsResult other = (StudentsResult) obj;
		return Objects.equals(marks, other.marks) && Objects.equals(subject, other.subject)
				&& Objects.equals(username, other.username);
	}
}