package com.eatopian.dao;

import java.util.List;

import com.eatopian.entity.Restaurant;

public interface RestaurantDao {

	/**
	 * Create a restaurant and associate it with the token
	 */
	public void createRestaurant(Restaurant restaurant, String token);
	
	/**
	 * Get all the restaurants associated with the token
	 */
	public List<Restaurant> getRestaurants(String token);
	
	/**
	 * Get the restaurant with restaurantId
	 */
	public Restaurant getRestaurant(String restaurantId, String token);
	
	/**
	 * Add an image to the restaurant's gallery
	 */
	public void addImage(String restaurantId, byte[] image, String token);
	
}
