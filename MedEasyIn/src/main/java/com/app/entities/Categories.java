package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories extends BaseEntity{
	@Column(length = 50,nullable = false)
	private String categoryName;
	@Column(length = 1000,nullable = false)
	private String description;
	
	
	public Categories() {
		super();
	}


	public Categories(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Categories [category_Name=" + categoryName + ", description=" + description + ", getId()=" + getId()
				+ "]";
	}
	
	
	

}
