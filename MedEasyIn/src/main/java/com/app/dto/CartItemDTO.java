package com.app.dto;

public class CartItemDTO {
	private Integer quantity;
	private Long cartId;
	private Long productId;
	
	public CartItemDTO() {
		
	}

	public CartItemDTO(Integer quantity, Long cartId, Long productId) {
		super();
		this.quantity = quantity;
		this.cartId = cartId;
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CartItemDTO [quantity=" + quantity + ", cartId=" + cartId + ", productId=" + productId + "]";
	}
	
	

}
