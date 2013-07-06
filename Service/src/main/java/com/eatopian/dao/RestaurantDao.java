package com.eatopian.dao;

import com.eatopian.entity.Restaurant;

public interface RestaurantDao {

	public void saveImage(Restaurant restaurant, byte[] bytes);
	
}
