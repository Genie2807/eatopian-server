package com.eatopian.dao;

import java.util.List;

import com.eatopian.entity.Restaurant;

public interface RestaurantDao {

	public void createRestaurant(Restaurant restaurant, String token);
	
	/**
	 * Get all the restaurants associated with the token
	 */
	public List<Restaurant> getRestaurants(String token);
	
	public Restaurant getRestaurant(String restaurantId, String token);
	
	/**
	 * Add an image to the restaurant's gallery
	 */
	public void addImage(String restaurantId, byte[] image, String token);
	
}
