package com.smarteval.entities;

import java.util.Objects;

public class Category {
	private Integer categoryID;
	private String categoryName;
	
	public Category() {
		super();
	}
	public Category(Integer categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryID, categoryName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryID, other.categoryID) && Objects.equals(categoryName, other.categoryName);
	}
	
	
}
