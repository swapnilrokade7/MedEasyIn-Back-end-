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
	private Integer stock;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Categories categoryId;
	@Column(name = "image_path")
	private String imagePath;
//	@ManyToMany
//	@JoinColumn(name="order_id")
//	private Orders orderId;
	/*{"name":"Crocine","price":"12.0","description":"Fever Tablet","stock":"500","categoryId":"1","imagePath":"images/kiara.jpg"}*/
	
	
	public Products() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}


	public Products(String name, Double price, String description, Integer stock, Categories categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.categoryId = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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



	public Categories getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Categories categoryId) {
		this.categoryId = categoryId;
	}


	

}
