package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Valid
@Entity
@Table(name="delivery_address")
public class DeliveryAddress extends BaseEntity{
	@Column(length = 50,nullable = false)
	@NotBlank(message = "Address cannot be Blank")
	private String adress_Line1;
	@Column(length = 50,nullable = false)
	private String adress_Line2;
	@Column(length = 50,nullable = false)
	@NotBlank(message = "City cannot be Blank")
	private String city;
	@Column(length = 50,nullable = false)
	@NotBlank(message = "State cannot be Blank")
	private String state;
	@Column(length = 50,nullable = false)
	@Size(min=6,max=8)
	private String zipCode;
	@OneToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
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
	
	

}
