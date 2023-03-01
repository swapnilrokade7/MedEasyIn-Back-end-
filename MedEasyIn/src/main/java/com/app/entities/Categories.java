package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories extends BaseEntity{
	@Column(length = 50,nullable = false)
	private String category_Name;
	@Column(length = 1000,nullable = false)
	private String description;
	
	
	public Categories() {
		super();
	}


	public Categories(String category_Name, String description) {
		super();
		this.category_Name = category_Name;
		this.description = description;
	}


	public String getCategory_Name() {
		return category_Name;
	}


	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Categories [category_Name=" + category_Name + ", description=" + description + ", getId()=" + getId()
				+ "]";
	}
	
	
	

}
