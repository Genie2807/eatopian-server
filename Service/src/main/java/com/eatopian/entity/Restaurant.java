package com.eatopian.entity;

import java.util.ArrayList;

public class Restaurant extends User {
		
	protected Address address;
	protected String phoneNumber;
	protected int consumptionLevel;
	protected String style;
	
	protected Menu menu;
	protected ArrayList<Review> review;
	
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
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public ArrayList<Review> getReview() {
		return review;
	}
	public void setReview(ArrayList<Review> review) {
		this.review = review;
	}
			
}
