package com.smarteval.entities;

import java.util.Objects;

public class Users {
	private Integer userID;
	private String firstName;
	private String lastName;
	private String email; 
	private Integer phoneNumber;
	private String username;
	private Integer roleID;
	private Integer examID;

	public Users() {
		super();
	}

	public Users(Integer userID, String firstName, String lastName, String email,Integer  phoneNumber, String username,
			Integer roleID, Integer examID) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.roleID = roleID;
		this.examID = examID;
	}

	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getExamID() {
		return examID;
	}

	public void setExamID(Integer examID) {
		this.examID = examID;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", roleID=" + roleID + ", examID="
				+ examID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, examID, firstName, lastName, phoneNumber, roleID, userID, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(examID, other.examID)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(roleID, other.roleID)
				&& Objects.equals(userID, other.userID) && Objects.equals(username, other.username);
	}
	
	

}