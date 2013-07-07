package com.eatopian.entity;

import java.util.ArrayList;

public class Dish {
	
	private String dishName;
	private double price;
	private String description;
	private DishImage mainPage;
	
	private ArrayList<DishImage> gallery;
	private ArrayList<Review> reviews;
	
	
	
	
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DishImage getMainPage() {
		return mainPage;
	}
	public void setMainPage(DishImage mainPage) {
		this.mainPage = mainPage;
	}
	public ArrayList<DishImage> getGallery() {
		return gallery;
	}
	public void setGallery(ArrayList<DishImage> gallery) {
		this.gallery = gallery;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
