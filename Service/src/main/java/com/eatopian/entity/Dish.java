package com.eatopian.entity;

import java.util.List;

public class Dish {
	
	private String dishName;
	private double price;
	private String description;
	private DishImage mainPageImage;
	
	private List<DishImage> gallery;
	private List<Review> reviews;
	
	
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
	public DishImage getMainPageImage() {
		return mainPageImage;
	}
	public void setMainPageImage(DishImage mainPageImage) {
		this.mainPageImage = mainPageImage;
	}
	public List<DishImage> getGallery() {
		return gallery;
	}
	public void setGallery(List<DishImage> gallery) {
		this.gallery = gallery;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
		
	
}
