package com.eatopian.dao;

import com.eatopian.entity.Restaurant;

public interface RestaurantDao {

	public void createRestaurant(Restaurant restaurant, String token);
	
	public Restaurant getRestaurant(String token);
	
	public void saveImage(String restaurantId, byte[] bytes, String token);
	
}
