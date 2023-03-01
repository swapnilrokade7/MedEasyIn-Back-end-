package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products extends BaseEntity{
	@Column(name = "name",length = 20,nullable = false)
	private String name;
	@Column(nullable = false)
	private Double price;
	private String description;
	private Boolean inStock;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Categories categoryId;
	@Column(name = "image_path")
	private String imagePath;
//	@ManyToMany
//	@JoinColumn(name="order_id")
//	private Orders orderId;
	
	
	
	public Products() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}


	public Products(String name, Double price, String description, Boolean inStock, Categories categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.inStock = inStock;
		this.categoryId = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getInStock() {
		return inStock;
	}


	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}


	public Categories getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Categories categoryId) {
		this.categoryId = categoryId;
	}


	

}
