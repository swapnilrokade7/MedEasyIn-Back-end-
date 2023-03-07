package com.app.dto;

public class DeliveryAddressDTO{
	private String adress_Line1;
	private String adress_Line2;
	private String city;
	private String state;
	private String zipCode;
	
	public DeliveryAddressDTO() {
		super();
		System.out.println("in ctor "+getClass().getName());
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public DeliveryAddressDTO(String adress_Line1, String adress_Line2, String city, String state, String zipCode) {
		super();
		this.adress_Line1 = adress_Line1;
		this.adress_Line2 = adress_Line2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	
	
	
	

}
