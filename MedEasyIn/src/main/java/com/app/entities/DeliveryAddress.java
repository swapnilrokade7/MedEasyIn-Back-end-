package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name="delivery_address")
public class DeliveryAddress extends BaseEntity{
	@Column(length = 50,nullable = false)
	private String adress_Line1;
	@Column(length = 50,nullable = false)
	private String adress_Line2;
	@Column(length = 50,nullable = false)
	private String city;
	@Column(length = 50,nullable = false)
	private String state;
	@Column(length = 50,nullable = false)
	private String zipCode;
	@OneToOne
	@JoinColumn(name="order_id")
	private Orders orderInfo;
	
	public DeliveryAddress() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}

	public DeliveryAddress(String adress_Line1, String adress_Line2, String city, String state, String zip_Code) {
		super();
		this.adress_Line1 = adress_Line1;
		this.adress_Line2 = adress_Line2;
		this.city = city;
		this.state = state;
		this.zipCode = zip_Code;
		}

	public String getAdress_Line1() {
		return adress_Line1;
	}

	public void setAdress_Line1(String adress_Line1) {
		this.adress_Line1 = adress_Line1;
	}

	public String getAdress_Line2() {
		return adress_Line2;
	}

	public void setAdress_Line2(String adress_Line2) {
		this.adress_Line2 = adress_Line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_Code() {
		return zipCode;
	}

	public void setZip_Code(String zipCode) {
		this.zipCode = zipCode;
	}

	public Orders getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Orders orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String toString() {
		return "DeliveryAddress [adress_Line1=" + adress_Line1 + ", adress_Line2=" + adress_Line2 + ", city=" + city
				+ ", state=" + state + ", zip_Code=" + zipCode + ", orderInfo=" + orderInfo + ", getId()=" + getId()
				+ "]";
	}
	
	
	

}
