package com.app.dto;

public class CartItemRespDTO {
	private Integer quantity;
	private Double totalPrice;
	
	public CartItemRespDTO() {
		
	}

	public CartItemRespDTO(Integer quantity, Double totalPrice) {
		super();
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItemRespDTO [quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}

	
	
	

}
