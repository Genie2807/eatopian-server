package com.eatopian.entity;

import java.util.List;

public class Restaurant{
	
	protected String name;
	
	protected Address address;
	
	protected String phoneNumber;
	
	protected int consumptionLevel;
	
	protected String style;
	
	protected String status;
	
	protected double longitude;
	
	protected double latitude;
	
//	protected String schedule;
		
	protected Menu menu;
	
	protected List<Review> review;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getConsumptionLevel() {
		return consumptionLevel;
	}
	public void setConsumptionLevel(int consumptionLevel) {
		this.consumptionLevel = consumptionLevel;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
				
}
