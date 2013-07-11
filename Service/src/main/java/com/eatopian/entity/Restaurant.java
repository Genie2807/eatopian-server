package com.eatopian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Restaurant")
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
	
	protected List<Review> reviews;
	
	public Restaurant(){
		this.reviews = new ArrayList<Review>();
		this.longitude = 7;
		this.latitude = 28;	
		Review review = new Review();
		review.setDatetime(new Date());
		review.setReview("caonima");
		this.reviews.add(review);
		
	}
	
	
	
	
	
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
				
}
