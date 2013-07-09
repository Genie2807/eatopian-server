package com.eatopian.dao;

import com.eatopian.entity.Restaurant;

public interface RestaurantDao {

	public void createRestaurant(Restaurant restaurant, String token);
	
	public Restaurant getRestaurants(String token);
	
	public Restaurant getRestaurant(String restaurantId, String token);
	
	public void addImage(String restaurantId, byte[] bytes, String token);
	
}
