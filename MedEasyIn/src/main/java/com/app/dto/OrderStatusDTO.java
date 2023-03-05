package com.app.dto;

public class OrderStatusDTO {
	
	private Long orderId;
	private String status;
	
	public OrderStatusDTO() {
		super();
	}

	public OrderStatusDTO(Long orderId, String status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
