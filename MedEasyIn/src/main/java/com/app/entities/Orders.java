package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Orders extends BaseEntity{
	@Column(nullable = false)
	private LocalDate orderDate;
	@Column(nullable = false)
	private LocalDate deliveryDate;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	@Column(nullable = false)
	private double totalPrice;
	@Column
	private double shippingPrice;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userOrdered;
	@OneToMany(mappedBy = "orderId")
	
	private List<OrderDetails> orderDetailsSet = new ArrayList<OrderDetails>();
	@OneToOne
	private DeliveryAddress address;
	
	
	public Orders() {
		super();
		System.out.println("in ctor of"+getClass().getName());
	}


	public Orders(LocalDate orderDate, LocalDate deliveryDate, Status status, double totalPrice, double shippingPrice,
			Users userOrdered, DeliveryAddress address) {
		super();
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.totalPrice = totalPrice;
		this.shippingPrice = shippingPrice;
		this.userOrdered = userOrdered;
		this.address = address;
	}
	
	public Orders(LocalDate orderDate, LocalDate deliveryDate, Status status, double totalPrice, double shippingPrice,
			String userOrdered, String address) {
		super();
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.totalPrice = totalPrice;
		this.shippingPrice = shippingPrice;
		
	}


	@Override
	public String toString() {
		return "Orders [orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", status=" + status
				+ ", totalPrice=" + totalPrice + ", shippingPrice=" + shippingPrice + ", userOrdered=" + userOrdered
				+ ", orderDetailsSet=" + orderDetailsSet + ", address=" + address + "]";
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public double getShippingPrice() {
		return shippingPrice;
	}


	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}


	public Users getUserOrdered() {
		return userOrdered;
	}


	public void setUserOrdered(Users userOrdered) {
		this.userOrdered = userOrdered;
	}


	public List<OrderDetails> getOrderDetails() {
		return orderDetailsSet;
	}


	public void setOrderDetails(OrderDetails orderDetails) {
		 orderDetailsSet.add(orderDetails);
	}


	public DeliveryAddress getAddress() {
		return address;
	}


	public void setAddress(DeliveryAddress address) {
		this.address = address;
	}


	

	
}
