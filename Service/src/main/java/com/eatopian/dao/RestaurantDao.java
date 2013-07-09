package com.eatopian.dao;

import java.util.List;

import com.eatopian.entity.Restaurant;
import com.eatopian.entity.Token;

public interface RestaurantDao {

	/**
	 * Create a restaurant and associate it with the token
	 */
	public void createRestaurant(Restaurant restaurant, Token token);
	
	/**
	 * Get all the restaurants associated with the token
	 */
	public List<Restaurant> getRestaurants(Token token);
	
	/**
	 * Get the restaurant with restaurantId
	 */
	public Restaurant getRestaurant(String restaurantId, Token token);
	
	/**
	 * Add an image to the restaurant's gallery
	 */
	public void addImage(String restaurantId, byte[] image, Token token);
	
}
