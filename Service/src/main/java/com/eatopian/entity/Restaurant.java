package com.eatopian.entity;

<<<<<<< HEAD
<<<<<<< HEAD
public class Restaurant extends Account {
=======
import java.util.List;

public class Restaurant{
	
	protected String name;
	protected Address address;
	protected String phoneNumber;
	protected int consumptionLevel;
	protected String style;
	protected String status;
	
	
	protected Menu menu;
	protected List<Review> review;
	
>>>>>>> GBranch
=======
public class Restaurant {
>>>>>>> 15c755d73f4e4e6d490baebcb7223a3249072f92
	
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
